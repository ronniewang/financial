package wang.ronnie.financial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import wang.ronnie.financial.persist.model.Assert;
import wang.ronnie.financial.service.AssertService;
import wang.ronnie.financial.validator.AssertValidator;

import javax.validation.Valid;
import java.util.List;

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

    @RequestMapping("/{userId}")
    @ResponseBody
    public List<Assert> all(@PathVariable Integer userId, @AuthenticationPrincipal UserDetails userDetails) {

        System.out.println(userDetails);
        return assertService.all(userId);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public String add(@Valid @RequestBody Assert a) {

        assertService.add(a);
        return "success";
    }
}
