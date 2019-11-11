package pl.coderslab.charity.web.controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.sevices.UserService;

import java.security.Principal;

@ControllerAdvice
public class GlobalController {

    private UserService userService;

    public GlobalController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("activeUser")
    public User activeUser(Principal principal) {
        if (principal != null)
            return userService.findUser(principal.getName());
        else return null;
    }
}
