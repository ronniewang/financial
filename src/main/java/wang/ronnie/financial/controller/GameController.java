package wang.ronnie.financial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import wang.ronnie.financial.model.ErrorResponse;
import wang.ronnie.financial.model.JsonArrayResponse;
import wang.ronnie.financial.persist.model.Game;
import wang.ronnie.financial.service.GameService;
import wang.ronnie.financial.validator.GameValidator;

import javax.validation.Valid;
import java.util.Optional;

/**
 * Created by ronniewang on 17/7/19.
 */
@Controller
@RequestMapping("/game")
public class GameController {

    @Autowired
    private GameValidator gameValidator;

    @InitBinder
    protected void initBinder(final WebDataBinder binder) {

        binder.addValidators(gameValidator);
    }

    @Autowired
    private GameService gameService;

    @RequestMapping("/person/{person}")
    @ResponseBody
    public JsonArrayResponse<Game> findByPerson(@PathVariable String person) {

        return new JsonArrayResponse<>(gameService.findByPerson(person));
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public String add(@Valid @RequestBody Game a) {

        gameService.add(a);
        return "success";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ErrorResponse delete(@PathVariable Optional<Integer> id) {

        if (id.isPresent()) {
            gameService.delete(id.get());
            return new ErrorResponse("0", "success");
        } else {
            return new ErrorResponse("1", "error");
        }
    }
}
