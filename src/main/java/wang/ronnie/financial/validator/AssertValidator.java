package wang.ronnie.financial.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import wang.ronnie.financial.persist.model.Assert;

/**
 * Created by ronniewang on 17/7/19.
 */
@Component
public class AssertValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {

        return clazz.equals(Assert.class);
    }

    @Override
    public void validate(Object target, Errors errors) {

        Assert a = (Assert) target;
        ValidationUtils.rejectIfEmpty(errors, "name", "name is blank");
        ValidationUtils.rejectIfEmpty(errors, "userId", "userId is blank");
        ValidationUtils.rejectIfEmpty(errors, "amount", "amount is blank");
        ValidationUtils.rejectIfEmpty(errors, "type", "type is blank");
        ValidationUtils.rejectIfEmpty(errors, "name", "name is blank");
        ValidationUtils.rejectIfEmpty(errors, "month", "month is blank");
        ValidationUtils.rejectIfEmpty(errors, "year", "year is blank");
    }
}
