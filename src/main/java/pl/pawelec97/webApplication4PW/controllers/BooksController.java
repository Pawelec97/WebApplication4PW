package pl.pawelec97.webApplication4PW.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.pawelec97.webApplication4PW.model.Book;
import pl.pawelec97.webApplication4PW.model.User;
import pl.pawelec97.webApplication4PW.repositories.BookRepository;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BooksController {


    private String dane;
    private String pole;
    private List<Book> books;


    private final BookRepository bookRepository;

    public BooksController(BookRepository bookRepository) {
        dane = "xxxxx";
        this.bookRepository = bookRepository;
    }


    @GetMapping("/index")
    public String welcome(Model model, HttpSession session) {
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

        model.addAttribute("currentDate", LocalDate.now().toString());
        model.addAttribute("input", pole);
        model.addAttribute("mojedane", dane);
        model.addAttribute("books", bookRepository.findAll());
        model.addAttribute("addbook", new Book());
        session.setAttribute("currentUser", currentUser);

        return "book";
    }

    @PostMapping("/add")
    public String addBook(Model model, @ModelAttribute Book addbook) {
        int newId= (int)bookRepository.count() + 1;
        while(bookRepository.findById(newId).isPresent()) newId++;
        addbook.setId(newId);
        bookRepository.save(addbook);
        model.addAttribute("books", bookRepository.findAll());

//        return "index";
        return "redirect:/book/index";
    }




    @GetMapping("/edit/{id}")
    public String editBook(@PathVariable("id") int id, Model model) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + id));

        model.addAttribute("book", book);
        return "book-form";
    }

    @PostMapping("/update/{id}")
    public String updateBook(@PathVariable("id") int id, @Valid Book book, Model model) {

            bookRepository.save(book);
            model.addAttribute("books", bookRepository.findAll());
            return "redirect:/book/index";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") int id, Model model) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + id));
        bookRepository.delete(book);
//        model.addAttribute("books", bookRepository.findAll());
        return "redirect:/book/index";
    }

}
