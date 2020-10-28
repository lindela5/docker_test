package com.innowise.darya.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "publishing_house")
@Getter
@Setter
@EqualsAndHashCode(exclude = {"bookEntities"})
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
