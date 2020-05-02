package pl.Pawelec97.WebApplication2PW.entities;

import javax.persistence.*;

@Entity
@Table(name = "Book")
public class Book {
    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "Title")
    private String title;

    @Column(name = "Author")
    private String author;

    public Book(Integer id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public Book() {
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
