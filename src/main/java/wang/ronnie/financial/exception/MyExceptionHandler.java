package wang.ronnie.financial.exception;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import wang.ronnie.financial.model.JsonObjectResponse;

/**
 * Created by ronniewang on 17/7/19.
 */
@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler({BindException.class, MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Object handler(Exception ex) {

        if (ex instanceof MethodArgumentNotValidException) {
            System.out.println(ex);
            return ((MethodArgumentNotValidException) ex).getBindingResult();
        }
        return "error";
    }

    @ExceptionHandler({CommonException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public JsonObjectResponse catchAll(CommonException ex) {

        return new JsonObjectResponse(ex.getCode(), ex.getMessage());
    }

}
