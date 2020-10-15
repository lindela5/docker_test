package com.innowise.darya.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "publishing_house")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(builderMethodName = "auPublishingHouse")
public class PublishingHouse {

    @Id
    private Long publisherId;
    @Column(name = "name_publisher")
    private String namePublisher;
    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "publisher")
    private List<BookEntity> publisherBooks = new ArrayList<>();

}
