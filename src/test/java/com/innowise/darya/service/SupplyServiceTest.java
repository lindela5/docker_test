package com.innowise.darya.service;

import com.innowise.darya.dto.BookDTO;
import com.innowise.darya.entity.Book;
import com.innowise.darya.entity.Supplier;
import com.innowise.darya.entity.Supply;
import com.innowise.darya.exception.ThereIsNoSuchException;
import com.innowise.darya.repositoty.BookRepository;
import com.innowise.darya.repositoty.SupplyRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

import static java.math.BigDecimal.TEN;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.only;

@ExtendWith(MockitoExtension.class)
class SupplyServiceTest {

    @Mock
    SupplyRepository supplyRepository;

    @InjectMocks
    SupplyService supplyService;

    private static final Long WRONG_ID = 18L;
    static final Long ID = 1L;

    static final Set<Book> BOOK_SUPPLY = Set.of(
            Book.aBook().bookId(2L).price(TEN).build(),
            Book.aBook().bookId(3L).price(TEN).build());

    static final Supplier SUPPLIER = Supplier.builder()
            .id(1L)
            .supplierName("Perfect books")
            .address("14 Pinskaya Street, Gomel, Belarus")
            .phone("+375291251256")
            .build();
    static final LocalDate SUPPLY_DATE = LocalDate.parse("2020-01-14");
    static final BigDecimal SUPPLIER_PRICE = new BigDecimal(213);

    //@formatter=off

    static final Supply SUPPLY =
            Supply.builder()
                    .supplyId(ID)
                    .bookSupply(BOOK_SUPPLY)
                    .supplier(SUPPLIER)
                    .supplyDate(SUPPLY_DATE)
                    .supplierPrice(SUPPLIER_PRICE)
                    .build();
    //@formatter=on

    @Test
    public void shouldThrowSupplyException() {
        given(supplyRepository.findBySupplyId(WRONG_ID)).willReturn(null);
        assertThrows(ThereIsNoSuchException.class, () -> supplyService.getSupplyStats(WRONG_ID));
        then(supplyRepository).should(only()).findBySupplyId(WRONG_ID);

    }

    @Test
    public void shouldReturnBookStat() {
        given(supplyRepository.findBySupplyId(ID)).willReturn(SUPPLY);
        Supply actual = supplyService.getSupplyStats(ID);
        assertEquals(SUPPLY, actual);
        then(supplyRepository).should(only()).findBySupplyId(ID);

    }

}