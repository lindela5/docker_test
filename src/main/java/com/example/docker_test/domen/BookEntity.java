package com.example.docker_test.domen;

import lombok.Data;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "books")
@Data
public class BookEntity {

    @Id
    private Long id;

    private String title;
    private String author;
    private Integer yearOfIssue;


}
