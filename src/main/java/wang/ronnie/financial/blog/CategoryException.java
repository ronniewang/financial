package wang.ronnie.financial.blog;

import wang.ronnie.financial.exception.CommonException;

/**
 * Created by ronniewang on 17/8/10.
 */
public class CategoryException extends CommonException {

    public CategoryException(String code, String message) {

        super(code, message);
    }
}
