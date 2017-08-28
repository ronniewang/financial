package wang.ronnie.converter;

import java.util.Date;
import java.util.List;

/**
 * Created by ronniewang on 17/8/7.
 */
public class Essay {

    private String rawContent;

    private String htmlContent;

    private Date date;

    private String author = "Ronnie Wang";

    private String desc;

    private List<String> tags;

    public String getRawContent() {

        return rawContent;
    }

    public void setRawContent(String rawContent) {

        this.rawContent = rawContent;
    }

    public String getHtmlContent() {

        return htmlContent;
    }

    public void setHtmlContent(String htmlContent) {

        this.htmlContent = htmlContent;
    }

    public Date getDate() {

        return date;
    }

    public void setDate(Date date) {

        this.date = date;
    }

    public String getAuthor() {

        return author;
    }

    public void setAuthor(String author) {

        this.author = author;
    }

    public String getDesc() {

        return desc;
    }

    public void setDesc(String desc) {

        this.desc = desc;
    }

    public List<String> getTags() {

        return tags;
    }

    public void setTags(List<String> tags) {

        for (String tag : tags) {
            tag = tag.trim();
        }
        this.tags = tags;
    }
}
