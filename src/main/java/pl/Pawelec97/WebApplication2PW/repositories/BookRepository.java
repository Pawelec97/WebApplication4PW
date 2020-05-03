package pl.Pawelec97.WebApplication2PW.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.Pawelec97.WebApplication2PW.model.Book;

public interface BookRepository extends JpaRepository<Book,Integer> {
//    List<Book> findAll();

}
