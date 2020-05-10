package pl.pawelec97.webApplication4PW;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pawelec97.webApplication4PW.model.User;
import pl.pawelec97.webApplication4PW.repositories.UserRepository;

import java.util.List;


@RestController
@RequestMapping("/rest/users")
public class UserRestController {

    final UserRepository userRepository;


    public UserRestController(UserRepository userRepository) {

        this.userRepository = userRepository;
    }


    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
