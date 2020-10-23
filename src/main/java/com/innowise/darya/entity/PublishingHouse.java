package com.innowise.darya.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "publishing_house")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PublishingHouse {

    @Id
    private Long publishingHouseId;
    private String namePublisher;
    private String address;

    @OneToMany(mappedBy = "publishingHouse")
    private Set<Book> bookEntities = new HashSet<>();

}
