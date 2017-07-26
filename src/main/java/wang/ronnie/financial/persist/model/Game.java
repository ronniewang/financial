package wang.ronnie.financial.persist.model;

import java.io.Serializable;
import java.util.Date;

public class Game implements Serializable {

    private Integer id;

    private Date createTime;

    private String person;

    private String thing;

    private Integer score;

    private Date day;

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

    public Integer getScore() {

        return score;
    }

    public void setScore(Integer score) {

        this.score = score;
    }

    public Date getDay() {

        return day;
    }

    public void setDay(Date day) {

        this.day = day;
    }

    @Override
    public String toString() {

        return "Game{" +
                "id=" + id +
                ", createTime=" + createTime +
                ", person='" + person + '\'' +
                ", thing='" + thing + '\'' +
                ", score=" + score +
                ", day=" + day +
                '}';
    }
}