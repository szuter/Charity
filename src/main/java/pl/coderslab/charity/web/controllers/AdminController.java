package pl.coderslab.charity.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.sevices.AdminService;

import java.security.Principal;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping
    public String prepareAdminPage(Model model){
        model.addAttribute("allDonations",adminService.getAllDonations());
        return "admin-index";
    }


    @GetMapping("/institutions")
    public String prepareAdminInstitutionsPage(Model model){
        model.addAttribute("institutions",adminService.getAllInstitutions());
        return "admin-institutions";
    }

    @GetMapping("/users")
    public String prepareAdminUsersPage(Model model){
        model.addAttribute("allUsers",adminService.getAllUsers());
        return "admin-users";
    }

    @GetMapping("/admins")
    public String prepareAdminAdminsPage(Model model, Principal principal){
        model.addAttribute("allAdmins",adminService.getAllOtherAdmins(principal.getName()));
        return "admin-admins";
    }

}
