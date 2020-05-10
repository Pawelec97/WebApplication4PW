package pl.pawelec97.webApplication4PW.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "book")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Book {
    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "Title")
    private String title;

    @Column(name = "Author")
    private String author;


}
