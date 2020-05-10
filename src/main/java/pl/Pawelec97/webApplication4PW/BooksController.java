package pl.pawelec97.webApplication4PW;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.pawelec97.webApplication4PW.model.Book;
import pl.pawelec97.webApplication4PW.model.User;
import pl.pawelec97.webApplication4PW.repositories.BookRepository;
import pl.pawelec97.webApplication4PW.repositories.UserRepository;
import pl.pawelec97.webApplication4PW.security.UserService;

import java.time.LocalDate;
import java.util.List;

@org.springframework.stereotype.Controller
public class BooksController {


    private String dane;
    private String pole;
    private List<Book> books;


    private BookRepository bookRepository;
    final UserRepository userRepository;
    final UserService userService;

    @Autowired
    public BooksController(BookRepository bookRepository, UserRepository userRepository,
                           UserService userService){
        dane = "xxxxx";
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
        this.userService = userService;
    }


    @GetMapping("/index")
    public String welcome(Model model) {

        model.addAttribute("currentDate",  LocalDate.now().toString());
        model.addAttribute("input", pole);
        model.addAttribute("mojedane",dane);
        model.addAttribute("books", bookRepository.findAll());
        model.addAttribute("addbook",new Book());
        return "index";
    }

    @PostMapping("/add")
    public String addBook(Model model,@ModelAttribute Book addbook){
        bookRepository.save(addbook);
        return "redirect:/";
    }
    @GetMapping("/")
    public String home(Model model) {
        return "nie jestes zalogowany";
    }


//    @PostMapping("/")
//    public String addCar(Model model, @RequestParam String input) {
//        dane += input;
//        model.addAttribute("currentDate", LocalDate.now().toString());
//        model.addAttribute("input", pole);
//        model.addAttribute("mojedane",dane);
//        return "index";
//    }

}
