package wang.ronnie.financial.exception;

/**
 * Created by ronniewang on 17/7/19.
 */
public class AssertException extends Exception {

    private String code;

    public AssertException(String message, String code) {

        super(message);
        this.code = code;
    }

    public String getCode() {

        return code;
    }
}
