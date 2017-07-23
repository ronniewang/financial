package wang.ronnie.financial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import wang.ronnie.financial.model.ErrorResponse;
import wang.ronnie.financial.model.JsonArrayResponse;
import wang.ronnie.financial.persist.model.Assert;
import wang.ronnie.financial.service.AssertService;
import wang.ronnie.financial.validator.AssertValidator;

import javax.validation.Valid;
import java.util.Optional;

/**
 * Created by ronniewang on 17/7/19.
 */
@Controller
@RequestMapping("/assert")
public class AssertController {

    @Autowired
    private AssertValidator assertValidator;

    @InitBinder
    protected void initBinder(final WebDataBinder binder) {

        binder.addValidators(assertValidator);
    }

    @Autowired
    private AssertService assertService;

    @RequestMapping("/{id}")
    @ResponseBody
    public JsonArrayResponse<Assert> all(@PathVariable Integer id, @AuthenticationPrincipal UserDetails userDetails) {

        System.out.println(userDetails);
        return new JsonArrayResponse<Assert>(assertService.all(id));
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public String add(@Valid @RequestBody Assert a) {

        assertService.add(a);
        return "success";
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ErrorResponse delete(@PathVariable Optional<Integer> id) {

        if (id.isPresent()) {
            assertService.delete(id.get());
            return new ErrorResponse("0", "success");
        } else {
            return new ErrorResponse("1", "error");
        }
    }
}
