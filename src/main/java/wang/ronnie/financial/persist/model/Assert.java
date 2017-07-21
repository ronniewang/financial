package wang.ronnie.financial.persist.model;

import java.io.Serializable;
import java.util.Date;

public class Assert implements Serializable {

    private Integer id;

    private Integer year;

    private Integer month;

    private Integer type;

    private Integer amount;

    private Date createTime;

    private Date updateTime;

    private Integer createUserId;

    private Integer updateUserId;

    private Integer userId;

    private String name;

    private static final long serialVersionUID = 1L;

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {

        this.id = id;
    }

    public Integer getYear() {

        return year;
    }

    public void setYear(Integer year) {

        this.year = year;
    }

    public Integer getMonth() {

        return month;
    }

    public void setMonth(Integer month) {

        this.month = month;
    }

    public Integer getAmount() {

        return amount;
    }

    public void setAmount(Integer amount) {

        this.amount = amount;
    }

    public Date getCreateTime() {

        return createTime;
    }

    public void setCreateTime(Date createTime) {

        this.createTime = createTime;
    }

    public Date getUpdateTime() {

        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {

        this.updateTime = updateTime;
    }

    public Integer getCreateUserId() {

        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {

        this.createUserId = createUserId;
    }

    public Integer getUpdateUserId() {

        return updateUserId;
    }

    public void setUpdateUserId(Integer updateUserId) {

        this.updateUserId = updateUserId;
    }

    public Integer getType() {

        return type;
    }

    public void setType(Integer type) {

        this.type = type;
    }

    public Integer getUserId() {

        return userId;
    }

    public void setUserId(Integer userId) {

        this.userId = userId;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }
}