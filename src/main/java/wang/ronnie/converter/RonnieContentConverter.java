package wang.ronnie.converter;

import j2html.tags.ContainerTag;
import org.apache.commons.io.FileUtils;
import wang.ronnie.converter.exception.ErrorFormatContent;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static j2html.TagCreator.*;

/**
 * Created by ronniewang on 17/8/7.
 */
public class RonnieContentConverter {

    List<List<String>> paragraphList = new ArrayList<>();

    private static final String H1_PREFIX = "= ";

    private static final String H2_PREFIX = "== ";

    private static final String H3_PREFIX = "=== ";

    private static final String H4_PREFIX = "==== ";

    private static final String UL1_PREFIX = "* ";

    private static final String UL2_PREFIX = "** ";

    private static final String UL3_PREFIX = "*** ";

    private static final String OL1_PREFIX = ". ";

    private static final String OL2_PREFIX = ".. ";

    private static final String OL3_PREFIX = ".. ";

    public String convert(List<String> lines) throws ErrorFormatContent {

        List<String> paragraphLines = new ArrayList<>();
        for (String line : lines) {
            if (line.isEmpty()) {
                paragraphList.add(paragraphLines);
                paragraphLines = new ArrayList<>();
            } else {
                paragraphLines.add(line);
            }
        }

        ContainerTag div = div();
        for (List<String> paragraph : paragraphList) {

            for (String line : paragraph) {
                if (line.startsWith(H1_PREFIX)) {
                    div.with(h1(line.replace(H1_PREFIX, "")));
                    continue;
                }
                if (line.startsWith(H2_PREFIX)) {
                    div.with(h2(line.replace(H2_PREFIX, "")));
                    continue;
                }
                if (line.startsWith(H3_PREFIX)) {
                    div.with(h3(line.replace(H3_PREFIX, "")));
                    continue;
                }
                if (line.startsWith(H4_PREFIX)) {
                    div.with(h4(line.replace(H4_PREFIX, "")));
                    continue;
                }
                //other markups
                boolean isUl1 = false;
                if (line.startsWith(UL1_PREFIX)) {
                    isUl1 = true;
                    div.with(ul());
                }
            }
        }
        return div.render();
    }

    public static void main(String[] args) throws IOException, ErrorFormatContent {

        List<String> lines = FileUtils.readLines(new File("/Users/ronniewang/me/antifragile/fragile_push_hand.adoc"), "utf-8");
        String content = new RonnieContentConverter().convert(lines);
        System.out.println(content);
    }
}
