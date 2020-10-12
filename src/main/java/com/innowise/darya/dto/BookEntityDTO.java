package com.innowise.darya.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(builderMethodName = "aBookEntityDTO")
public class BookEntityDTO {

    private Long bookId;
    private String bookTitle;
    private String bookAuthor;


}
