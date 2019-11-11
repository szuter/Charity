package pl.coderslab.charity.web.controllers;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.dto.DonationFormDTO;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.sevices.DonationService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.Principal;

@Controller
public class DonationController {


    private DonationService donationService;

    public DonationController(DonationService donationService) {
        this.donationService = donationService;
    }


    @GetMapping("/addDonation")
    public String prepareAddDonationPage(Model model, Principal principal) {

        model.addAttribute("data", new DonationFormDTO());
        model.addAttribute("categoryList", donationService.getCategories());
        model.addAttribute("institutionList", donationService.getInstitutions());
        return "add-donation";
    }

    @PostMapping("/addDonation")
    public String processAddDonationPage(@ModelAttribute("data") @Valid DonationFormDTO data, BindingResult result) {
        donationService.AddDonation(data);
        return "form-confirmation";
    }

    @GetMapping("/showDonations")
    public String prepareShowDonationPage(Model model,Principal principal) {
        model.addAttribute("userDonations", donationService.getAllUserDonations(principal.getName()));
        return "show-donations";
    }

    @RequestMapping("/showDonations/changeStatus")
    public String processChangeStatusPage(@RequestParam Long id){
        donationService.changeStatus(id);
        return "redirect:/showDonations";
    }

    @RequestMapping("/showDonations/info")
    public String processDonationInfoPage(Model model,@RequestParam Long id){
        model.addAttribute("data",donationService.getDonation(id));
        return "donation-info";
    }
}
