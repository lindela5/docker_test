package com.innowise.darya.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(builderMethodName = "auPublishingHouseDTO")
public class PublishingHouseDTO {

    private Long publishingHouseId;
    private String publisherName;
    private String publisherAddress;


}
