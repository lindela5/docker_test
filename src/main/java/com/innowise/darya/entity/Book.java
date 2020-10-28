package com.innowise.darya.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "books")
@Getter
@Setter
@EqualsAndHashCode(exclude = {"author"})
@AllArgsConstructor
@NoArgsConstructor
@Builder (builderMethodName = "aBook")
public class Book {

    @Id
    private Long bookId;

    private String title;

    @NotBlank
    @ManyToMany
    @JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "bookId"),
            inverseJoinColumns = @JoinColumn(name = "authorId"))
    private Set<Author> author = new HashSet<>();

    private String isbn;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="section_id")
    private Section section;

    private Integer yearOfIssue;

    @NotBlank
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="publishing_house_id")
    private PublishingHouse publishingHouse;

    private BigDecimal price;
    private Integer stockBalances;

    @ManyToMany(mappedBy = "bookOrder")
    private Set<Order> orderBooks = new HashSet<>();

    @ManyToMany(mappedBy = "bookSupply")
    private Set<Supply> supplyBook = new HashSet<>();

}
