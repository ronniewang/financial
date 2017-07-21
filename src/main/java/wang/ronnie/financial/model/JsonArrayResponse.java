package wang.ronnie.financial.model;

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

    private List<T> list;

    public List<T> getList() {

        return list;
    }

    public void setList(List<T> list) {

        this.list = list;
    }
}
