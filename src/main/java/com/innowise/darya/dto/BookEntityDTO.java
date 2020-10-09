package com.innowise.darya.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(builderMethodName = "aBookEntityDTO")
public class BookEntityDTO {

    private Long bookId;
    private String bookTitle;
    private String bookAuthor;


}
