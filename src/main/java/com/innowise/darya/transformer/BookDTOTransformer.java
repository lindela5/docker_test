package com.innowise.darya.transformer;

import com.innowise.darya.dto.BookEntityDTO;
import com.innowise.darya.entity.BookEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookDTOTransformer {
    BookDTOTransformer BOOK_DTO_TRANSFORMER = Mappers.getMapper(BookDTOTransformer.class);

    @Mappings({
            @Mapping(target = "bookId", source = "entity.bookId"),
            @Mapping(target = "bookTitle", source = "entity.title"),
            @Mapping(target = "bookAuthor", source = "entity.author"),
            @Mapping(target = "isbn", source = "entity.isbn"),
            @Mapping(target = "yearOfIssue", source = "entity.yearOfIssue"),
            @Mapping(target = "publishingHouse", source = "entity.publishingHouse"),
            @Mapping(target = "price", source = "entity.price"),
            @Mapping(target = "stockBalances", source = "entity.stockBalances")
    })
    BookEntityDTO bookEntityToBookEntityDTO(BookEntity entity);

    /*@Mappings({
            @Mapping(target="id", source="dto.bookId"),
            @Mapping(target="title", source="dto.bookTitle"),
            @Mapping(target="author", source="dto.bookAuthor")
    })*/
    @InheritInverseConfiguration
    //Аннотация определяет, что обратное отображение @InheritInverseConfiguration должно быть выполнено.
    BookEntity bookEntityDTOtoBookEntity(BookEntityDTO dto);
}