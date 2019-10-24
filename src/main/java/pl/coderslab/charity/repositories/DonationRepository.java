package pl.coderslab.charity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.charity.model.Donation;


public interface DonationRepository extends JpaRepository<Donation, Long> {


    @Query(value = "select sum(d.quantity) from Donation d")
    Long sumOfDonationQuantity();
    @Query(value = "select count(distinct d.institution) from Donation d")
    Long countOfInstitutions();
}
