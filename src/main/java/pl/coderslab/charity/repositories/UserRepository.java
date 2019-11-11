package pl.coderslab.charity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.charity.model.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    long countByEmail(String email);

    User findByEmail(String email);

    List<User> findAllByAccess(String role);
}
