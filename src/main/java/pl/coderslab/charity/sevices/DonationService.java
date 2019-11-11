package pl.coderslab.charity.sevices;


import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.dto.DonationFormDTO;
import pl.coderslab.charity.model.Category;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.repositories.CategoryRepository;
import pl.coderslab.charity.repositories.DonationRepository;
import pl.coderslab.charity.repositories.InstitutionRepository;
import pl.coderslab.charity.repositories.UserRepository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class DonationService {


    private DonationRepository donationRepository;
    private CategoryRepository categoryRepository;
    private InstitutionRepository institutionRepository;
    private UserRepository userRepository;

    private ModelMapper mapper = new ModelMapper();

    public DonationService(DonationRepository donationRepository, CategoryRepository categoryRepository, InstitutionRepository institutionRepository, UserRepository userRepository) {
        this.donationRepository = donationRepository;
        this.categoryRepository = categoryRepository;
        this.institutionRepository = institutionRepository;
        this.userRepository = userRepository;
    }

    public List<Institution> getInstitutions() {
        return institutionRepository.findAll();
    }

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    public void AddDonation(DonationFormDTO data) {
        Donation donation = mapper.map(data, Donation.class);
        donation.setStatus("Nieodebrane");
        donationRepository.save(donation);
    }

    public List<Donation> getAllUserDonations( String email) {
        List<Donation> donations = donationRepository.findAllByUserOrderByStatusAscDeliveredDescCreatedDesc(userRepository.findByEmail(email));
        return donations;
    }

    public void changeStatus(Long id) {
        Donation donation = donationRepository.getOne(id);
        donation.setStatus("Odebrano");
        donation.setDelivered(LocalDate.now());
        donationRepository.save(donation);
    }

    public Donation getDonation(Long id) {
        return donationRepository.getOne(id);
    }
}
