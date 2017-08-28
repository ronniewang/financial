package wang.ronnie.financial.blog;

/**
 * Created by ronniewang on 17/8/10.
 */
public enum Category {

    BODY_BUILDING(1, "BODY BUILDING"),
    PSYCHOLOGY(2, "PSYCHOLOGY"),
    ESSAY(3, "ESSAY");

    private Integer id;

    private String desc;

    Category(Integer id, String desc) {

        this.id = id;
        this.desc = desc;
    }

    public Integer getId() {

        return id;
    }

    public String getDesc() {

        return desc;
    }

}
