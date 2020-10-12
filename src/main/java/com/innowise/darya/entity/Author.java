package com.innowise.darya.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "author")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(builderMethodName = "aAuthorDTO")
public class Author {

    @Id
    private Long author_id;

    private String firstName;
    private String lastName;
    private String country;

    @ManyToMany(mappedBy = "authors")
    private Set<BookEntity> authorBooks = new HashSet<>();


}
