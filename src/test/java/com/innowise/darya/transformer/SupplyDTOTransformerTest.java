package com.innowise.darya.transformer;

import com.innowise.darya.dto.BookDTO;
import com.innowise.darya.dto.OrderDTO;
import com.innowise.darya.dto.SupplierDTO;
import com.innowise.darya.dto.SupplyDTO;
import com.innowise.darya.entity.*;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

import static java.math.BigDecimal.TEN;
import static org.junit.jupiter.api.Assertions.*;

class SupplyDTOTransformerTest {

    static final SupplyDTOTransformer SUPPLY_DTO_TRANSFORMER = Mappers.getMapper(SupplyDTOTransformer.class);
    static final Long ID = 1L;

    static final Set<Book> BOOK_SUPPLY = Set.of(
            Book.aBook().bookId(2L).price(TEN).build(),
            Book.aBook().bookId(3L).price(TEN).build());
    static final Set<BookDTO> BOOK_SUPPLY_DTO = Set.of(
            BookDTO.builder().bookId(2L).price(TEN).build(),
            BookDTO.builder().bookId(3L).price(TEN).build());


    static final Supplier SUPPLIER = Supplier.builder()
            .id(1L)
            .supplierName("Perfect books")
            .address("14 Pinskaya Street, Gomel, Belarus")
            .phone("+375291251256")
            .build();
    static final LocalDate SUPPLY_DATE = LocalDate.parse("2020-01-14");
    static final BigDecimal SUPPLIER_PRICE = new BigDecimal(213);


    //@formatter=off
    static final SupplyDTO SUPPLY_DTO =
            SupplyDTO.builder()
                    .supplyId(ID)
                    .bookSupply(BOOK_SUPPLY_DTO)
                    .supplier(SUPPLIER)
                    .supplyDate(SUPPLY_DATE)
                    .supplierPrice(SUPPLIER_PRICE)
                    .build();

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
    public void shouldReturnSupplyDTO() {

        Supply supply = SUPPLY_DTO_TRANSFORMER.supplyDTOToSupply(SUPPLY_DTO);

        assertEquals(SUPPLY_DTO.getSupplyId(), supply.getSupplyId());
        assertEquals(SUPPLY_DTO.getBookSupply(), supply.getBookSupply());
        assertEquals(SUPPLY_DTO.getSupplier(), supply.getSupplier());
        assertEquals(SUPPLY_DTO.getSupplyDate(), supply.getSupplyDate());
        assertEquals(SUPPLY_DTO.getSupplierPrice(), supply.getSupplierPrice());
    }

    @Test
    public void shouldReturnSupply() {

        SupplyDTO supplyDto = SUPPLY_DTO_TRANSFORMER.supplyToSupplyDTO(SUPPLY);

        assertEquals(SUPPLY.getSupplyId(), supplyDto.getSupplyId());
        assertEquals(SUPPLY.getBookSupply(), supplyDto.getBookSupply());
        assertEquals(SUPPLY.getSupplier(), supplyDto.getSupplier());
        assertEquals(SUPPLY.getSupplyDate(), supplyDto.getSupplyDate());
        assertEquals(SUPPLY.getSupplierPrice(), supplyDto.getSupplierPrice());
    }
}