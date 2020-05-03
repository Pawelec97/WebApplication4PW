package pl.Pawelec97.WebApplication2PW.model;

import javax.persistence.*;

@Entity
@Table(name = "borrow")
public class Borrow {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "borrow_date")
    private java.sql.Date borrowDate;

    @Column(name = "book_id")
    private String bookId;

    @Column(name = "reader_id")
    private String readerId;


    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public java.sql.Date getBorrowDate() {
        return this.borrowDate;
    }

    public void setBorrowDate(java.sql.Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public String getBookId() {
        return this.bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getReaderId() {
        return this.readerId;
    }

    public void setReaderId(String readerId) {
        this.readerId = readerId;
    }
}
