package com.innowise.darya.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "books")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(builderMethodName = "aBookEntity")
public class BookEntity {

    @Id
    private Long bookId;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    @NotBlank
    @ManyToMany
    @JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "bookId"),
            inverseJoinColumns = @JoinColumn(name = "authorId"))
    private Set<Author> author = new HashSet<>();

    @Column(name = "isbn")
    private String isbn;
    @Column(name = "year_of_issue")
    private Integer yearOfIssue;

    @Column(name = "publishing_house")
    @NotBlank
    @ManyToOne(cascade = CascadeType.ALL)
    private PublishingHouse publishingHouse;

    @Column(name = "price")
    private int price;
    @Column(name = "stock_balances")
    private Integer stockBalances;


}
