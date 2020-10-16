package com.innowise.darya.dto;

import com.innowise.darya.entity.Author;
import com.innowise.darya.entity.PublishingHouse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(builderMethodName = "aBookEntityDTO")
public class BookEntityDTO {

    private Long bookId;
    private String bookTitle;
    private Set<Author> bookAuthor = new HashSet<>();
    private String isbn;
    private Integer yearOfIssue;
    private PublishingHouse publishingHouse;
    private int price;
    private Integer stockBalances;
}
