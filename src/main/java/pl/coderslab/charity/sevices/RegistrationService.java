package pl.coderslab.charity.sevices;


import org.modelmapper.ModelMapper;
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

    private ModelMapper mapper = new ModelMapper();

    public RegistrationService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean isAvailable(String email) {
        Long count = userRepository.countByEmail(email);
        return count <= 0;
    }

    public void register(RegisterFormDTO data) {
        User user = mapper.map(data,User.class);
        user.setAccess("ROLE_USER");
        user.setPassword(passwordEncoder.encode(data.getPassword()));
        userRepository.save(user);

    }
}
