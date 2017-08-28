package wang.ronnie.converter.creator;

/**
 * Created by ronniewang on 17/8/7.
 */
public class UlCreator {

    StringBuilder content;

    public static UlCreator ul() {

        return new UlCreator();
    }

    public UlCreator start() {

        content = new StringBuilder("<ul>\n");
        return this;
    }

    public UlCreator li(String text) {

        content.append("  <li>" + text + "</li>\n");
        return this;
    }

    public UlCreator ul(UlCreator ulCreator) {

        content.append(ulCreator.render());
        return this;
    }

    public UlCreator end() {

        content.append("</ul>\n");
        return this;
    }

    public String render() {

        return content.toString();
    }

}
