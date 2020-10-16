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
@Builder(builderMethodName = "aPublishingHouse")
public class PublishingHouse {

    @Id
    private Long publishingHouseId;
    @Column(name = "name_publisher")
    private String namePublisher;
    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "publishingHouse")
    private Set<BookEntity> bookEntities = new HashSet<>();

}
