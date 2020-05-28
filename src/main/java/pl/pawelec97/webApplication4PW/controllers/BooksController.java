package pl.pawelec97.webApplication4PW.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.pawelec97.webApplication4PW.model.Book;
import pl.pawelec97.webApplication4PW.repositories.BookRepository;

import java.time.LocalDate;
import java.util.List;

@Controller
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
    public String welcome(Model model) {

        model.addAttribute("currentDate", LocalDate.now().toString());
        model.addAttribute("input", pole);
        model.addAttribute("mojedane", dane);
        model.addAttribute("books", bookRepository.findAll());
        model.addAttribute("addbook", new Book());
        return "index";
    }

    @PostMapping("/add")
    public String addBook(Model model, @ModelAttribute Book addbook) {
        bookRepository.save(addbook);
        return "redirect:/index";
    }

}
