package pl.coderslab.charity.sevices;


import org.springframework.stereotype.Service;
import pl.coderslab.charity.dto.DonationFormDTO;
import pl.coderslab.charity.model.Category;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.repositories.CategoryRepository;
import pl.coderslab.charity.repositories.DonationRepository;
import pl.coderslab.charity.repositories.InstitutionRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DonationService {


    private DonationRepository donationRepository;
    private CategoryRepository categoryRepository;
    private InstitutionRepository institutionRepository;

    public DonationService(DonationRepository donationRepository, CategoryRepository categoryRepository, InstitutionRepository institutionRepository) {
        this.donationRepository = donationRepository;
        this.categoryRepository = categoryRepository;
        this.institutionRepository = institutionRepository;
    }


    public List<Institution> getInstitutions() {
        return institutionRepository.findAll();
    }

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    public void AddDonation(DonationFormDTO data) {
        Donation donation = new Donation();
        donation.setCategories(data.getCategories());
        donation.setCity(data.getCity());
        donation.setInstitution(data.getInstitution());
        donation.setPhone(data.getPhone());
        donation.setPickUpComment(data.getPickUpComment());
        donation.setPickUpDate(data.getPickUpDate());
        donation.setPickUpTime(data.getPickUpTime());
        donation.setZipCode(data.getZipCode());
        donation.setQuantity(data.getQuantity());
        donation.setStreet(data.getStreet());
        donation.setUser(data.getUser());
        donationRepository.save(donation);
    }

    public List<Donation> getAllUserDonations(User user) {
        List<Donation> donations = donationRepository.findAllByUser(user);
        return donations;
    }

}
