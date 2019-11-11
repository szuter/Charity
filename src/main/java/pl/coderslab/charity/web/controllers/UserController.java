package pl.coderslab.charity.web.controllers;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.dto.PasswordFormDTO;
import pl.coderslab.charity.dto.UserFormDTO;
import pl.coderslab.charity.sevices.UserService;

import javax.validation.Valid;
import java.security.Principal;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/editUser")
    public String prepareUserEditPage(Model model, Principal principal) {
        model.addAttribute("data", userService.getUserForm(principal.getName()));
        return "edit-user";
    }

    @PostMapping("/editUser")
    public String processUserEditPage(@ModelAttribute("data") @Valid UserFormDTO data, BindingResult result) {
        if (result.hasErrors())
            return "edit-user";
        userService.editUser(data);
        return "index";
    }

    @GetMapping("/editUser/resetPassword")
    public String prepareUserResetPasswordPage(Model model) {
        model.addAttribute("data", new PasswordFormDTO());
        return "user-reset-password";
    }

    @PostMapping("/editUser/resetPassword")
    public String processUserResetPasswordPage(@ModelAttribute("data") @Valid PasswordFormDTO data, BindingResult result, Principal principal) {
        if (result.hasErrors())
            return "user-reset-password";
        if (!userService.passwordMatch(data.getActualPassword(), principal.getName())) {
            result.rejectValue("actualPassword", null, "Hasło niepoprawne");
            return "user-reset-password";
        }
        if (!data.getNewPassword().equals(data.getReNewPassword())) {
            result.rejectValue("rePassword", null, "Hasła nie zgodne");
            return "user-reset-password";
        }
        userService.resetPassword(data, principal.getName());
        return "redirect:/editUser";
    }

}
