package pl.coderslab.charity.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.dto.DonationFormDTO;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.sevices.DonationService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class DonationController {


    private DonationService donationService;

    public DonationController(DonationService donationService) {
        this.donationService = donationService;
    }


    @GetMapping("/addDonation")
    public String prepareAddDonationPage(Model model) {
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
    public String prepareShowDonationPage(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        model.addAttribute("userDonations", donationService.getAllUserDonations(user));
        return "show-donations";
    }
}
