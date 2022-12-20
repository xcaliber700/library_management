package co.pragra.learning.librarymgmt.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(unique = true)
    private String isbn;
    private String title;
    private String category;
    @OneToOne(cascade = CascadeType.ALL)
    private Author author;
    private Date publishDate;
    private Date createDate;
    @OneToMany
    private List<Review> reviews;
}
