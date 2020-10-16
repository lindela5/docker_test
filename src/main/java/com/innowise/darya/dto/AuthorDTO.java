package com.innowise.darya.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(builderMethodName = "aAuthorDTO")
public class AuthorDTO {

    private Long authorId;
    private String authorFirstName;
    private String authorLastName;
    private String authorCountry;
}
