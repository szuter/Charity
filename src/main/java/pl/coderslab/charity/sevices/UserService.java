package pl.coderslab.charity.sevices;


import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.dto.PasswordFormDTO;
import pl.coderslab.charity.dto.UserFormDTO;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.repositories.UserRepository;

import javax.transaction.Transactional;

@Transactional
@Service
public class UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private ModelMapper mapper = new ModelMapper();

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserFormDTO getUserForm(String email) {
        return mapper.map(userRepository.findByEmail(email), UserFormDTO.class);
    }

    public void editUser(UserFormDTO data) {
        User user = userRepository.getOne(data.getId());
        user.setFirstName(data.getFirstName());
        user.setLastName(data.getLastName());
        userRepository.save(user);
    }

    public User findUser(String email){
        return userRepository.findByEmail(email);
    }

    public boolean passwordMatch(String actualPassword,String email) {
        return passwordEncoder.matches(actualPassword, userRepository.findByEmail(email).getPassword());
    }

    public void resetPassword(PasswordFormDTO data,String email) {
        User user = userRepository.findByEmail(email);
        user.setPassword(passwordEncoder.encode(data.getNewPassword()));
        userRepository.save(user);
    }
}
