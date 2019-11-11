package pl.coderslab.charity.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.dto.UserFormDTO;
import pl.coderslab.charity.sevices.AdminService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin/users")
public class AdminUsersController {

    private AdminService adminService;


    public AdminUsersController(AdminService adminService) {
        this.adminService = adminService;
    }

    @ModelAttribute("roles")
    public List<String> roles(){
        List<String> list = new ArrayList<>();
        list.add("ROLE_USER");
        list.add("ROLE_ADMIN");
        return list;
    }

    @GetMapping("/edit")
    public String prepareAdminEditUserPage(Model model, @RequestParam Long id) {
        model.addAttribute("data", adminService.getUser(id));
        return "admin-edit-users";
    }

    @PostMapping("/edit")
    public String processAdminEditUserPage(@ModelAttribute("data") @Valid UserFormDTO data, BindingResult result){
        if (result.hasErrors())
            return "admin-edit-users";
        adminService.editUser(data);
        return "redirect:/admin/users";
    }

}
