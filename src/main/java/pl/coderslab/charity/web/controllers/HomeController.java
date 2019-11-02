package pl.coderslab.charity.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.sevices.HomepageService;

import javax.servlet.http.HttpSession;
import java.security.Principal;


@Controller
public class HomeController {

    private HomepageService homepageService;

    public HomeController(HomepageService homepageService) {
        this.homepageService = homepageService;
    }

    @RequestMapping("/")
    public String homeAction(Model model, HttpSession httpSession, Principal principal) {
        if (principal != null) {
            httpSession.setAttribute("user", homepageService.activeUser(principal.getName()));
        }
        model.addAttribute("bagQuantity", homepageService.getQuantity());
        model.addAttribute("supportedInstitutions", homepageService.getInstitutionCount());
        model.addAttribute("allInstitutions", homepageService.getInstitutions());
        return "index";
    }
}
