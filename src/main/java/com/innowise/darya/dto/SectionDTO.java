package com.innowise.darya.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder  //(builderMethodName = "aSectionDTO")
public class SectionDTO {

    private Long id;
    private String nameSection;
}
