package pl.pawelec97.webApplication4PW.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "borrow")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Borrow {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "borrow_date")
    private java.sql.Date borrowDate;

    @Column(name = "book_id")
    private Integer bookId;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "return_date")
    private java.sql.Date returnDate;



}
