package wang.ronnie.financial.model;

/**
 * Created by ronniewang on 17/6/14.
 */
public abstract class AbstractResponse {

    private String code;

    private String msg;

    public String getCode() {

        return code;
    }

    public void setCode(String code) {

        this.code = code;
    }

    public String getMsg() {

        return msg;
    }

    public void setMsg(String msg) {

        this.msg = msg;
    }
}
