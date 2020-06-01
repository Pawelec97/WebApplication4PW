package pl.pawelec97.webApplication4PW.controllers;


import org.hibernate.annotations.Parameter;
import org.springframework.data.domain.Example;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/byId")
    public Book getById(@RequestParam int id) {

        return bookRepository.findById(id).get();
    }
    @GetMapping("/search")
    public List<Book> search(@RequestParam String id, @RequestParam String title, @RequestParam String author){
        Integer idNumber = null;
        if(!id.isEmpty()) idNumber = Integer.getInteger(id);

        Book example1 = new Book(idNumber,null,null);
        Book example2 = new Book(null,title,null);
        Book example3 = new Book(null,null,author);
        List<Book> lista = bookRepository.findAll(Example.of(example1));
        lista.addAll(bookRepository.findAll(Example.of(example2)));
        lista.addAll(bookRepository.findAll(Example.of(example3)));
        return lista;
    }
}
