package com.innowise.darya.service;

import com.innowise.darya.entity.PublishingHouse;
import com.innowise.darya.exception.ThereIsNoSuchException;
import com.innowise.darya.repositoty.PublishingHouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class PublishingHouseService {
    private PublishingHouseRepository publishingHouseRepository;

    @Autowired
    public PublishingHouseService(PublishingHouseRepository publishingHouseRepository) {
        this.publishingHouseRepository = publishingHouseRepository;
    }


    public PublishingHouse getPublisherStats(Long publishingHouseId) {
        PublishingHouse publisher = publishingHouseRepository.findByPublishingHouseId(publishingHouseId);
        if (publisher == null) {
            throw new ThereIsNoSuchException();
        }
        return publisher;
    }
}
