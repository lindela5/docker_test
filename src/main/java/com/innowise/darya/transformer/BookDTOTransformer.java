package com.innowise.darya.transformer;

import com.innowise.darya.entity.BookEntity;
import com.innowise.darya.dto.BookEntityDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookDTOTransformer {
    BookDTOTransformer TRANSFORMER = Mappers.getMapper(BookDTOTransformer.class);

    @Mappings({
            @Mapping(target="bookId", source="entity.id"),
            @Mapping(target="bookTitle", source="entity.title"),
            @Mapping(target="bookAuthor", source="entity.author")
    })
    BookEntityDTO bookEntityToBookEntityDTO(BookEntity entity);
    @Mappings({
            @Mapping(target="id", source="dto.bookId"),
            @Mapping(target="title", source="dto.bookTitle"),
            @Mapping(target="author", source="dto.bookAuthor")
    })
    BookEntity bookEntityDTOtoBookEntity(BookEntityDTO dto);
}