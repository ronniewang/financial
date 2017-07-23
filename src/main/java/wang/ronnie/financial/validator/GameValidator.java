package wang.ronnie.financial.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import wang.ronnie.financial.persist.model.Game;

/**
 * Created by ronniewang on 17/7/19.
 */
@Component
public class GameValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {

        return clazz.equals(Game.class);
    }

    @Override
    public void validate(Object target, Errors errors) {

        Game game = (Game) target;
        ValidationUtils.rejectIfEmpty(errors, "thing", "thing is blank");
        ValidationUtils.rejectIfEmpty(errors, "person", "person is blank");
    }
}
