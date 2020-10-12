package com.innowise.darya.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "publishingHouse")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(builderMethodName = "auPublishingHouse")
public class PublishingHouse {

    @Id
    private Long publisher_id;

    private String namePublisher;
    private String address;

    @OneToMany(mappedBy = "publisher")
    private Set<BookEntity> publisherBooks = new HashSet<>();

}
