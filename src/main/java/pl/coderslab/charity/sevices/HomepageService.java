package pl.coderslab.charity.sevices;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.repositories.DonationRepository;
import pl.coderslab.charity.repositories.InstitutionRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class HomepageService {

    private DonationRepository donationRepository;
    private InstitutionRepository institutionRepository;

    public HomepageService(DonationRepository donationRepository, InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
        this.donationRepository = donationRepository;
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
}
