package com.innowise.darya.dto;

import com.innowise.darya.entity.PublishingHouse;
import com.innowise.darya.entity.Section;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder //(builderMethodName = "aBookDTO")
public class BookDTO {

    private Long bookId;
    private String bookTitle;
    private Set<AuthorDTO> bookAuthor;
    private String isbn;
    private Section section;
    private Integer yearOfIssue;
    private PublishingHouse publishingHouse;
    private BigDecimal price;
    private Integer stockBalances;
    private String picture;
}
