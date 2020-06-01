package pl.pawelec97.webApplication4PW.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.pawelec97.webApplication4PW.model.User;
import pl.pawelec97.webApplication4PW.repositories.UserRepository;
import pl.pawelec97.webApplication4PW.services.UserService;

import javax.servlet.http.HttpSession;
import java.util.List;

;

@Controller
public class UsersController {
    final UserRepository userRepository;
    private UserService userService;

    public UsersController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }
    @GetMapping("/chat")
    public String chat() {
        return "chat";
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
        return "redirect:/book/index";
    }
    @GetMapping("/user-info")
    public String userInfo(Model model, HttpSession httpSession) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        int currentUserId;
        String username;
        User currentUser;
        if (principal instanceof UserDetails) {
            currentUser = (User)principal;
            currentUserId = ((User) (principal)).getId();
            username = ((User) (principal)).getUsername();
        } else {
            currentUser = null;
            currentUserId = -1;
            username = principal.toString();
        }
        httpSession.setAttribute("user",currentUser);
        return "user-info";
    }
}
