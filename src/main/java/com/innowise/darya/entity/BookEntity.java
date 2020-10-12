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
    private Long id;

    private String title;

    @NotBlank
    @ManyToMany
    @JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors = new HashSet<>();

    private String isbn;
    private Integer yearOfIssue;

    @NotBlank
    @ManyToOne
    private PublishingHouse publisher;


    private int price;
    private Integer stockBalances;


}
