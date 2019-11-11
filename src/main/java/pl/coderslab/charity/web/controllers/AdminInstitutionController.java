package pl.coderslab.charity.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.dto.InstitutionFormDTO;
import pl.coderslab.charity.sevices.InstitutionService;

import javax.validation.Valid;


@Controller
@RequestMapping("/admin/institutions")
public class AdminInstitutionController {

    private InstitutionService institutionService;

    public AdminInstitutionController(InstitutionService institutionService) {
        this.institutionService = institutionService;
    }

    @GetMapping("/add")
    public String prepareInstitutionAddPage(Model model) {
        model.addAttribute("data", new InstitutionFormDTO());
        return "admin-menage-institution";
    }

    @PostMapping("/add")
    public String processInstitutionAddPage(@ModelAttribute("data") @Valid InstitutionFormDTO data, BindingResult result) {
        if (result.hasErrors()) {
            return "admin-menage-institution";
        }
        institutionService.addInstitution(data);
        return "redirect:/admin/institutions";
    }

    @GetMapping("/delete")
    public String processDeleteInstitutionPage(@RequestParam Long id) {
        institutionService.deleteInstitution(id);
        return "redirect:/admin/institutions";
    }

    @GetMapping("/edit")
    public String prepareInstitutionEditPage(@RequestParam Long id, Model model) {
        model.addAttribute("data", institutionService.getInstitution(id));
        return "admin-menage-institution";
    }

    @PostMapping("/edit")
    public String processInstitutionEditPage(@ModelAttribute("data") @Valid InstitutionFormDTO data, BindingResult result){
        if (result.hasErrors())
            return "admin-menage-institution";
        institutionService.addInstitution(data);
        return "redirect:/admin/institutions";
    }

}
