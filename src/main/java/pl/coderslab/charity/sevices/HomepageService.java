package pl.coderslab.charity.sevices;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.repositories.DonationRepository;

import javax.transaction.Transactional;

@Transactional
@Service
public class HomepageService {

    private DonationRepository donationRepository;

    public HomepageService(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }

    public Long getQuantity(){
       return donationRepository.sumOfDonationQuantity();
    }

    public Long getInstitutions(){
        return donationRepository.countOfInstitutions();
    }
}
