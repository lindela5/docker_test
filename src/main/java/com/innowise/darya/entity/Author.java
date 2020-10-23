package com.innowise.darya.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "author")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Author {

    @Id
    private Long authorId;

    private String firstName;
    private String lastName;
    private String country;

    @ManyToMany(mappedBy = "author")
    private Set<Book> authorBooks = new HashSet<>();


}
