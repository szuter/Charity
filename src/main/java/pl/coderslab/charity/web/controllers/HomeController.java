package pl.coderslab.charity.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.sevices.HomepageService;


@Controller
public class HomeController {

    private HomepageService homepageService;

    public HomeController(HomepageService homepageService) {
        this.homepageService = homepageService;
    }

    @RequestMapping("/")
    public String homeAction(Model model) {
        model.addAttribute("bagQuantity", homepageService.getQuantity());
        model.addAttribute("supportedInstitutions", homepageService.getInstitutions());
        return "index";
    }
}
