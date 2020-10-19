package com.innowise.darya.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SectionDTO {

    private Long id;
    private String nameSection;
}
