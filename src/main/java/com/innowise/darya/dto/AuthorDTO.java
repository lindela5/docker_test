package com.innowise.darya.dto;

import com.innowise.darya.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthorDTO {

    private Long authorId;
    private String authorFirstName;
    private String authorLastName;
    private String authorCountry;
 //   private Set<BookDTO> authorBooks = new HashSet<>();
}
