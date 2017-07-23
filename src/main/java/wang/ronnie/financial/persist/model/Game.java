package wang.ronnie.financial.persist.model;

import java.io.Serializable;
import java.util.Date;

public class Game implements Serializable {

    private Integer id;

    private Date createTime;

    private String person;

    private String thing;


    private static final long serialVersionUID = 1L;

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {

        this.id = id;
    }

    public Date getCreateTime() {

        return createTime;
    }

    public void setCreateTime(Date createTime) {

        this.createTime = createTime;
    }

    public String getPerson() {

        return person;
    }

    public void setPerson(String person) {

        this.person = person;
    }

    public String getThing() {

        return thing;
    }

    public void setThing(String thing) {

        this.thing = thing;
    }
}