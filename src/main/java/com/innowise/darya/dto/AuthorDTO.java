package com.innowise.darya.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(builderMethodName = "aAuthorDTO")
public class AuthorDTO {

    private Long authorId;
    private String authorFirstName;
    private String authorLastName;
    private String authorCountry;

    private Set<BookEntityDTO> authorBooks; //= new HashSet<>();


}
