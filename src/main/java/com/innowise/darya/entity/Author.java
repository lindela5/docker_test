package com.innowise.darya.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "author")
@Getter
@Setter
@EqualsAndHashCode(exclude = {"authorBooks"})
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString//(exclude = {"authorBooks"})
public class Author {

    @Id
    private Long authorId;

    private String firstName;
    private String lastName;
    private String country;

//    @ManyToMany(mappedBy = "author")
//    private Set<Book> authorBooks = new HashSet<>();


}
