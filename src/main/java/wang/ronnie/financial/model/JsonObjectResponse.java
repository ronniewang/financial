package wang.ronnie.financial.model;

/**
 * Created by ronniewang on 17/6/14.
 */
public class JsonObjectResponse<T> extends AbstractResponse {

    public JsonObjectResponse(T object, String code, String msg) {

        this.setCode(code);
        this.setMsg(msg);
        this.object = object;
    }

    private T object;

    public T getObject() {

        return object;
    }

    public void setObject(T object) {

        this.object = object;
    }
}
