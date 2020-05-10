package pl.pawelec97.webApplication4PW.DTOs;

public class BorrowDTO {
    private Integer id;
    private java.sql.Date borrowDate;
    private String bookId;
    private String readerId;

    public Integer getId() {
        return id;
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
