package pl.coderslab.charity.sevices;


import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.dto.RegisterFormDTO;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.repositories.UserRepository;

import javax.transaction.Transactional;

@Service
@Transactional
public class RegistrationService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public RegistrationService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean isAvailable(String email) {
        Long count = userRepository.countByEmail(email);
        return count <= 0;
    }

    public void register(RegisterFormDTO data) {
        User user = new User();
        user.setAccess("ROLE_USER");
        user.setEmail(data.getEmail());
        user.setPassword(passwordEncoder.encode(data.getPassword()));
        user.setFirstName(data.getFirstName());
        user.setLastName(data.getLastName());
        userRepository.save(user);

    }
}
