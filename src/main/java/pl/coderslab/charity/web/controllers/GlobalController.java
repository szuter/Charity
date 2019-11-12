package pl.coderslab.charity.web.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.sevices.HomepageService;
import pl.coderslab.charity.sevices.UserService;

import java.security.Principal;

@ControllerAdvice
public class GlobalController {

    private UserService userService;
    private HomepageService homepageService;

    public GlobalController(UserService userService, HomepageService homepageService) {
        this.userService = userService;
        this.homepageService = homepageService;
    }

    @ModelAttribute("activeUser")
    public User activeUser(Principal principal) {
        if (principal != null)
            return userService.findUser(principal.getName());
        else return null;
    }

    @ModelAttribute()
    public void homePage(Model model) {
        model.addAttribute("allInstitutions", homepageService.getInstitutions());
        model.addAttribute("bagQuantity", homepageService.getQuantity());
        model.addAttribute("supportedInstitutions", homepageService.getInstitutionCount());
    }
}
