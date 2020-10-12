package com.innowise.darya.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(builderMethodName = "auPublishingHouseDTO")
public class PublishingHouseDTO {

    private Long publisherId;
    private String publisherName;
    private String publisherAddress;


    private Set<BookEntityDTO> publisherBooks;// = new HashSet<>();


}
