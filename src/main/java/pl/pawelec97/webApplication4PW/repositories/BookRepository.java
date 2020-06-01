package pl.pawelec97.webApplication4PW.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pawelec97.webApplication4PW.model.Book;

public interface BookRepository extends JpaRepository<Book,Integer> {


}
