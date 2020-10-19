package com.innowise.darya.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sections")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Section {

    @Id
    private Long id;
    private String nameSection;
}
