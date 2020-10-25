package com.innowise.darya.transformer;

import com.innowise.darya.dto.BookDTO;
import com.innowise.darya.entity.Book;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static com.innowise.darya.entity.Book.aBook;

class BookDTOTransformerTest {

    static final BookDTOTransformer TRANSFORMER = Mappers.getMapper(BookDTOTransformer.class);
    static final Long ID = 1L;
    static final String BOOK_TITLE = "Madol Duwa";
    static final String BOOK_AUTHOR = "Martin Wickramasinghe";
    //@formatter=off
    static final BookDTO BOOK_DTO =
            BookDTO.builder()
                    .bookId(ID)
               //  .bookAuthor(BOOK_AUTHOR)
                    .bookTitle(BOOK_TITLE)
                    .build();

    static final Book BOOK =
            aBook()
                    .bookId(ID)
              //      .author(BOOK_AUTHOR)
                    .title(BOOK_TITLE)
                    .build();
    //@formatter=on

    @Test
    public void shouldReturnBookEntityDTO() {

        Book actualEntity = TRANSFORMER.bookDTOToBook(BOOK_DTO);

        assertEquals(BOOK_DTO.getBookId(), actualEntity.getBookId());
        assertEquals(BOOK_DTO.getBookTitle(), actualEntity.getTitle());
        assertEquals(BOOK_DTO.getBookTitle(), actualEntity.getTitle());
    }

    @Test
    public void shouldReturnBookEntity() {

        BookDTO bookDto = TRANSFORMER.bookToBookDTO(BOOK);

        assertEquals(BOOK.getBookId(), bookDto.getBookId());
        assertEquals(BOOK.getTitle(), bookDto.getBookTitle());
        assertEquals(BOOK.getTitle(), bookDto.getBookTitle());
    }
}