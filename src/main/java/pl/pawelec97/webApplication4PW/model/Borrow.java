package pl.pawelec97.webApplication4PW.model;

import javax.persistence.*;

@Entity
@Table(name = "borrow")
public class Borrow {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "borrow_date")
    private java.sql.Date borrowDate;

    @Column(name = "book_id")
    private Integer bookId;

    @Column(name = "reader_id")
    private Integer readerId;


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public java.sql.Date getBorrowDate() {
        return this.borrowDate;
    }

    public void setBorrowDate(java.sql.Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Integer getBookId() {
        return this.bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getReaderId() {
        return this.readerId;
    }

    public void setReaderId(Integer readerId) {
        this.readerId = readerId;
    }
}
