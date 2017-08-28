package wang.ronnie.financial.exception;

/**
 * Created by ronniewang on 17/8/10.
 */
public class CommonException extends Exception {

    private String code;

    public CommonException(String code, String message) {

        super(message);
        this.code = code;
    }

    public String getCode() {

        return code;
    }
}
