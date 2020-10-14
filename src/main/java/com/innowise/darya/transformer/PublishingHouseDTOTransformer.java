package com.innowise.darya.transformer;

import com.innowise.darya.dto.PublishingHouseDTO;
import com.innowise.darya.entity.PublishingHouse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PublishingHouseDTOTransformer {
    PublishingHouseDTOTransformer PUBLISHING_HOUSE_DTO_TRANSFORMER = Mappers.getMapper(PublishingHouseDTOTransformer.class);

    @Mappings({
            @Mapping(target = "publisherId", source = "entity.id"),
            @Mapping(target = "publisherName", source = "entity.title"),
            @Mapping(target = "publisherAddress", source = "entity.author")
    })
    PublishingHouseDTO publishingHouseToPublishingHouseDTO(PublishingHouse entity);

    @Mappings({
            @Mapping(target = "id", source = "dto.publisherId"),
            @Mapping(target = "title", source = "dto.publisherName"),
            @Mapping(target = "author", source = "dto.publisherAddress")
    })
    PublishingHouse publishingHouseDTOToBookEntity(PublishingHouseDTO dto);
}
