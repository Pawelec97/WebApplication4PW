package pl.pawelec97.webApplication4PW.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.pawelec97.webApplication4PW.model.User;
import pl.pawelec97.webApplication4PW.repositories.UserRepository;

@Service
public class UserService {

    private final UserRepository usersRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository usersRepository, PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void createAndAddUser(User appUser) {

        String encodePassword = getEncodedPassword(appUser);
        appUser.setPassword(encodePassword);
        int id = getIdForNewUser();
        appUser.setId(id);
        appUser.setRole("ROLE_ADMIN");

        usersRepository.save(appUser);
    }

    private String getEncodedPassword(User appUser) {
        String password = appUser.getPassword();
        return passwordEncoder.encode(password);
    }

    private int getIdForNewUser() {
        User lastUser = usersRepository.findFirstByOrderByIdDesc();
        if (lastUser == null) {
            return 1;
        }
        int lastId = lastUser.getId();
        return ++lastId;
    }

}