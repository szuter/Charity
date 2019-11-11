package pl.coderslab.charity.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.dto.RegisterFormDTO;
import pl.coderslab.charity.dto.UserFormDTO;
import pl.coderslab.charity.sevices.AdminService;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin/admins")
public class AdminAdminsController {

    private AdminService adminService;

    public AdminAdminsController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/add")
    public String prepareAddAdminPage(Model model) {
        model.addAttribute("data", new RegisterFormDTO());
        return "admin-add-admins";
    }

    @PostMapping("/add")
    public String processAddAdminPage(@ModelAttribute("data") @Valid RegisterFormDTO data, BindingResult result) {
        if (result.hasErrors())
            return "admin-add-admins";
        if (!data.getPassword().equals(data.getRePassword())) {
            result.rejectValue("rePassword", null, "Hasła nie zgodne");
            return "admin-add-admins";
        }
        if (!adminService.isAvailable(data.getEmail())) {
            result.rejectValue("email", null, "Email juz zajęty");
            return "admin-add-admins";
        }
        adminService.addAdmin(data);
        return "redirect:/admin/admins";
    }

    @GetMapping("/edit")
    public String prepareEditAdminPage(@RequestParam Long id, Model model) {
        model.addAttribute("data", adminService.getUser(id));
        return "admin-edit-admins";
    }

    @PostMapping("/edit")
    public String processEditAdminPage(@ModelAttribute("data") @Valid UserFormDTO data, BindingResult result) {
        if (result.hasErrors())
            return "admin-edit-admins";
        adminService.editUser(data);
        return "redirect:/admin/admins";
    }

    @GetMapping("/delete")
    public String prepareDeleteAdminPage(@RequestParam Long id) {
        adminService.deleteUser(id);
        return "redirect:/admin/admins";
    }
}
