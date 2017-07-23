package wang.ronnie.financial.model;

import wang.ronnie.financial.Constants;

import java.util.List;

/**
 * Created by ronniewang on 17/6/14.
 */
public class JsonArrayResponse<T> extends AbstractResponse {

    public JsonArrayResponse(List<T> list, String code, String msg) {
        this.setCode(code);
        this.setMsg(msg);
        this.list = list;
    }

    public JsonArrayResponse(List<T> list) {
        this.setCode(Constants.OK_CODE);
        this.setMsg(Constants.OK_MSG);
        this.list = list;
    }

    private List<T> list;

    public List<T> getList() {

        return list;
    }

    public void setList(List<T> list) {

        this.list = list;
    }
}
