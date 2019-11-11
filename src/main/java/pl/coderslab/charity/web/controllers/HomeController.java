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
    public String homeAction(Model model,Principal principal) {
        model.addAttribute("allInstitutions", homepageService.getInstitutions());
        if (principal != null) {
            if (homepageService.activeUser(principal.getName()).getAccess().equals("ROLE_ADMIN")) {
                return "redirect:/admin";
            }
        }
        model.addAttribute("bagQuantity", homepageService.getQuantity());
        model.addAttribute("supportedInstitutions", homepageService.getInstitutionCount());
        return "index";
    }
}
