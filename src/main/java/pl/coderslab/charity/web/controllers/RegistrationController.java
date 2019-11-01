package pl.coderslab.charity.web.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.dto.RegisterFormDTO;
import pl.coderslab.charity.sevices.RegistrationService;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    private RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping("/register")
    public String prepareRegisterPage(Model model) {
        model.addAttribute("data", new RegisterFormDTO());
        return "registration";
    }

    @PostMapping("/register")
    public String processRegisterPage(@ModelAttribute("data") @Valid RegisterFormDTO data, BindingResult result) {
        if (result.hasErrors()){
            return "registration";
        }
        if (!data.getPassword().equals(data.getRePassword())) {
            result.rejectValue("rePassword", null, "Hasła nie zgodne");
            return "registration";
        }
        if (!registrationService.isAvailable(data.getEmail())) {
            result.rejectValue("email", null, "Email juz zajęty");
            return "registration";
        }
        registrationService.register(data);
        return "index";
    }
}
