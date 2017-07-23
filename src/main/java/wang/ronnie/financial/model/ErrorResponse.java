package wang.ronnie.financial.model;

public class ErrorResponse extends AbstractResponse {

    public ErrorResponse(String code, String msg) {

        this.setCode(code);
        this.setMsg(msg);
    }
}
