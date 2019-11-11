package pl.coderslab.charity.sevices;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.dto.RegisterFormDTO;
import pl.coderslab.charity.dto.UserFormDTO;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.repositories.DonationRepository;
import pl.coderslab.charity.repositories.InstitutionRepository;
import pl.coderslab.charity.repositories.UserRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AdminService {


    private DonationRepository donationRepository;
    private InstitutionRepository institutionRepository;
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    private ModelMapper mapper = new ModelMapper();

    public AdminService(DonationRepository donationRepository, InstitutionRepository institutionRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.donationRepository = donationRepository;
        this.institutionRepository = institutionRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<Donation> getAllDonations() {
        return donationRepository.findAll();
    }

    public List<Institution> getAllInstitutions() {
        return institutionRepository.findAll();
    }

    public List<User> getAllUsers() {
        return userRepository.findAllByAccess("ROLE_USER");
    }

    public List<User> getAllOtherAdmins(String email) {
        List<User> users = userRepository.findAllByAccess("ROLE_ADMIN");
        users.remove(userRepository.findByEmail(email));
        return users;
    }

    public Boolean isAvailable(String email) {
        return userRepository.countByEmail(email) <= 0;
    }

    public void addAdmin(RegisterFormDTO data) {
        User user = mapper.map(data, User.class);
        user.setAccess("ROLE_ADMIN");
        user.setPassword(passwordEncoder.encode(data.getPassword()));
        userRepository.save(user);
    }

    public UserFormDTO getUser(Long id) {
        return mapper.map(userRepository.getOne(id), UserFormDTO.class);

    }

    public void editUser(UserFormDTO data) {
        User user = userRepository.getOne(data.getId());
        user.setFirstName(data.getFirstName());
        user.setLastName(data.getLastName());
        if (data.getAccess() != null)
            user.setAccess(data.getAccess());
        userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.delete(userRepository.getOne(id));
    }
}
