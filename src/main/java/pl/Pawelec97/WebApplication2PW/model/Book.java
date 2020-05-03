package pl.Pawelec97.WebApplication2PW.model;

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
    @Getter
    @Setter
    private Integer id;

    @Column(name = "Title")
    @Getter
    @Setter
    private String title;

    @Column(name = "Author")
    @Getter
    @Setter
    private String author;



}
