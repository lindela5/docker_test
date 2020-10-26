package com.innowise.darya.transformer;

import com.innowise.darya.dto.AuthorDTO;
import com.innowise.darya.dto.BookDTO;
import com.innowise.darya.entity.*;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.math.BigDecimal;
import java.util.Set;

import static java.math.BigDecimal.TEN;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static com.innowise.darya.entity.Book.aBook;

class BookDTOTransformerTest {

    static final BookDTOTransformer TRANSFORMER = Mappers.getMapper(BookDTOTransformer.class);
    static final Long ID = 2L;
    static final String BOOK_TITLE = "Good Omens";


    static final Set<Author> AUTHOR_BOOK = Set.of(
            Author.builder().authorId(8L).firstName("Neil").lastName("Gaiman").build(),
            Author.builder().authorId(9L).firstName("Terry").lastName("Pratchett").build());

    static final Set<AuthorDTO> AUTHOR_BOOK_DTO = Set.of(
            AuthorDTO.builder().authorId(8L).authorFirstName("Neil").authorLastName("Gaiman").build(),
            AuthorDTO.builder().authorId(9L).authorFirstName("Terry").authorLastName("Pratchett").build());


    static final String ISBN= "9781910281918";

    static final Section SECTION = Section.builder()
            .id(7L)
            .nameSection("Mystery")
            .build();

    static final Integer YEAR_OF_ISSUE = Integer.valueOf("2015");

    static final PublishingHouse PUBLISHING_HOUSE = PublishingHouse.builder()
            .publishingHouseId(2L)
            .namePublisher("BBC Books")
            .build();

    static final BigDecimal PRICE = new BigDecimal(23.16);
    static final Integer STOCK_BALANCES = Integer.valueOf("1");


    //@formatter=off
    static final BookDTO BOOK_DTO =
            BookDTO.builder()
                    .bookId(ID)
                    .bookTitle(BOOK_TITLE)
                    .bookAuthor(AUTHOR_BOOK_DTO)
                    .isbn(ISBN)
                    .section(SECTION)
                    .yearOfIssue(YEAR_OF_ISSUE)
                    .publishingHouse(PUBLISHING_HOUSE)
                    .price(PRICE)
                    .stockBalances(STOCK_BALANCES)
                    .build();

    static final Book BOOK =
            aBook()
                    .bookId(ID)
                    .title(BOOK_TITLE)
                    .author(AUTHOR_BOOK)
                    .isbn(ISBN)
                    .section(SECTION)
                    .yearOfIssue(YEAR_OF_ISSUE)
                    .publishingHouse(PUBLISHING_HOUSE)
                    .price(PRICE)
                    .stockBalances(STOCK_BALANCES)
                    .build();
    //@formatter=on

    @Test
    public void shouldReturnBookEntityDTO() {

        Book actualEntity = TRANSFORMER.bookDTOToBook(BOOK_DTO);

        assertEquals(BOOK_DTO.getBookId(), actualEntity.getBookId());
        assertEquals(BOOK_DTO.getBookTitle(), actualEntity.getTitle());
        assertEquals(BOOK_DTO.getBookAuthor(), actualEntity.getAuthor());
        assertEquals(BOOK_DTO.getIsbn(), actualEntity.getIsbn());
        assertEquals(BOOK_DTO.getSection(), actualEntity.getSection());
        assertEquals(BOOK_DTO.getYearOfIssue(), actualEntity.getYearOfIssue());
        assertEquals(BOOK_DTO.getPublishingHouse(), actualEntity.getPublishingHouse());
        assertEquals(BOOK_DTO.getPrice(), actualEntity.getPrice());
        assertEquals(BOOK_DTO.getStockBalances(), actualEntity.getStockBalances());
    }

    @Test
    public void shouldReturnBookEntity() {

        BookDTO bookDto = TRANSFORMER.bookToBookDTO(BOOK);

        assertEquals(BOOK.getBookId(), bookDto.getBookId());
        assertEquals(BOOK.getTitle(), bookDto.getBookTitle());
        assertEquals(BOOK.getAuthor(), bookDto.getBookAuthor());
        assertEquals(BOOK.getIsbn(), bookDto.getIsbn());
        assertEquals(BOOK.getSection(), bookDto.getSection());
        assertEquals(BOOK.getYearOfIssue(), bookDto.getYearOfIssue());
        assertEquals(BOOK.getPublishingHouse(), bookDto.getPublishingHouse());
        assertEquals(BOOK.getPrice(), bookDto.getPrice());
        assertEquals(BOOK.getStockBalances(), bookDto.getStockBalances());
    }
}