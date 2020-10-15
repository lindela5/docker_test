package com.innowise.darya.transformer;

import com.innowise.darya.dto.BookEntityDTO;
import com.innowise.darya.entity.BookEntity;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static com.innowise.darya.dto.BookEntityDTO.aBookEntityDTO;
import static com.innowise.darya.entity.BookEntity.aBookEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
/*
class BookDTOTransformerTest {

    static final BookDTOTransformer TRANSFORMER = Mappers.getMapper(BookDTOTransformer.class);
    static final Long ID = 1L;
    static final String BOOK_TITLE = "Madol Duwa";
    static final String BOOK_AUTHOR = "Martin Wickramasinghe";
    //@formatter=off
    static final BookEntityDTO BOOK_ENTITY_DTO =
            aBookEntityDTO()
                    .bookId(ID)
                    .bookAuthor(BOOK_AUTHOR)
                    .bookTitle(BOOK_TITLE)
                    .build();

    static final BookEntity BOOK_ENTITY =
            aBookEntity()
                    .id(ID)
                    .author(BOOK_AUTHOR)
                    .title(BOOK_TITLE)
                    .build();
    //@formatter=on

    @Test
    public void shouldReturnBookEntityDTO() {

        BookEntity actualEntity = TRANSFORMER.bookEntityDTOtoBookEntity(BOOK_ENTITY_DTO);

        assertEquals(BOOK_ENTITY_DTO.getBookId(), actualEntity.getId());
        assertEquals(BOOK_ENTITY_DTO.getBookTitle(), actualEntity.getTitle());
        assertEquals(BOOK_ENTITY_DTO.getBookTitle(), actualEntity.getTitle());
    }

    @Test
    public void shouldReturnBookEntity() {

        BookEntityDTO bookDto = TRANSFORMER.bookEntityToBookEntityDTO(BOOK_ENTITY);

        assertEquals(BOOK_ENTITY.getId(), bookDto.getBookId());
        assertEquals(BOOK_ENTITY.getTitle(), bookDto.getBookTitle());
        assertEquals(BOOK_ENTITY.getTitle(), bookDto.getBookTitle());
    }
}*/