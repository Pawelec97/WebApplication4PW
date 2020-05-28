package pl.pawelec97.webApplication4PW.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pawelec97.webApplication4PW.model.Book;
import pl.pawelec97.webApplication4PW.model.User;
import pl.pawelec97.webApplication4PW.repositories.BookRepository;
import pl.pawelec97.webApplication4PW.repositories.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/rest/books")
public class BooksRestController {

    BookRepository bookRepository;

    public BooksRestController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @GetMapping("/all")
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

}
