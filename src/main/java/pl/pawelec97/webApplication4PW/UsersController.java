package pl.pawelec97.webApplication4PW;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.pawelec97.webApplication4PW.model.User;
import pl.pawelec97.webApplication4PW.repositories.UserRepository;
import pl.pawelec97.webApplication4PW.services.UserService;

import java.util.List;

;

@Controller
@RequestMapping("/user")
public class UsersController {
    final UserRepository userRepository;
    private UserService userService;

    public UsersController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @GetMapping("/welcome-page")
    public String welcomePage(Model model) {
        List<User> users = userRepository.findAll();

        model.addAttribute("users", users);
        return "welcome-page";
    }

    @GetMapping("/sign-up")
    public String singUp(Model model) {
        model.addAttribute("user", new User());
        return "sign-up";
    }

    @PostMapping("/register")
    public String register(User appUser) {
        userService.createAndAddUser(appUser);
        return "redirect:/index";
    }

}
