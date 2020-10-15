package com.innowise.darya.transformer;

import com.innowise.darya.dto.AuthorDTO;
import com.innowise.darya.entity.Author;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthorDTOTransformer {
    AuthorDTOTransformer AUTHOR_DTO_TRANSFORMER = Mappers.getMapper(AuthorDTOTransformer.class);

    @Mappings({
            @Mapping(target = "authorId", source = "entity.authorId"),
            @Mapping(target = "authorFirstName", source = "entity.firstName"),
            @Mapping(target = "authorLastName", source = "entity.lastName"),
            @Mapping(target = "authorCountry", source = "entity.country")
    })
    AuthorDTO authorToAuthorDTO(Author entity);

    @Mappings({
            @Mapping(target = "authorId", source = "dto.authorId"),
            @Mapping(target = "firstName", source = "dto.authorFirstName"),
            @Mapping(target = "lastName", source = "dto.authorLastName"),
            @Mapping(target = "country", source = "dto.authorCountry")
    })
    Author authorDTOToAuthor(AuthorDTO dto);
}
