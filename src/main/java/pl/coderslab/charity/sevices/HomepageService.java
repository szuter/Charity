package pl.coderslab.charity.sevices;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.repositories.DonationRepository;
import pl.coderslab.charity.repositories.InstitutionRepository;
import pl.coderslab.charity.repositories.UserRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class HomepageService {

    private DonationRepository donationRepository;
    private InstitutionRepository institutionRepository;
    private UserRepository userRepository;

    public HomepageService(DonationRepository donationRepository, InstitutionRepository institutionRepository, UserRepository userRepository) {
        this.donationRepository = donationRepository;
        this.institutionRepository = institutionRepository;
        this.userRepository = userRepository;
    }

    public Long getQuantity() {
        return donationRepository.sumOfDonationQuantity();
    }

    public Long getInstitutionCount() {
        return donationRepository.countOfInstitutions();
    }

    public List<Institution> getInstitutions() {
        return institutionRepository.findAll();
    }

    public User activeUser(String email) {
        return userRepository.findByEmail(email);
    }
}
