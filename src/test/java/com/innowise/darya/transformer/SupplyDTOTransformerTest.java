package com.innowise.darya.transformer;

import com.innowise.darya.dto.OrderDTO;
import com.innowise.darya.dto.SupplierDTO;
import com.innowise.darya.dto.SupplyDTO;
import com.innowise.darya.entity.Customer;
import com.innowise.darya.entity.Order;
import com.innowise.darya.entity.Supplier;
import com.innowise.darya.entity.Supply;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class SupplyDTOTransformerTest {

    static final SupplyDTOTransformer SUPPLY_DTO_TRANSFORMER = Mappers.getMapper(SupplyDTOTransformer.class);
    static final Long ID = 1L;
    static final Supplier SUPPLIER = new Supplier();
    for (Supplier supplier : SUPPLY.getSupplier()) {
            SupplierDTO supplierDTO = new SupplierDTO();
            supplierDTO.setId(1L);
            supplierDTO.setSupplierName("Perfect books");
            supplierDTO.setAddress("14 Pinskaya Street, Gomel, Belarus");
            supplierDTO.setPhone("+375291251256");
            SUPPLIER.add(supplierDTO);
        }
    static final LocalDate SUPPLY_DATE = LocalDate.parse("2020-01-14");
    static final BigDecimal SUPPLIER_PRICE = new BigDecimal(213);

    //@formatter=off
    static final SupplyDTO SUPPLY_DTO =
            SupplyDTO.builder()
                    .supplyId(ID)
                    .supplier(SUPPLIER)
                    .supplyDate(SUPPLY_DATE)
                    .supplierPrice(SUPPLIER_PRICE)
                    .build();

    static final Supply SUPPLY =
            Supply.builder()
                    .supplyId(ID)
                    .supplier(SUPPLIER)
                    .supplyDate(SUPPLY_DATE)
                    .supplierPrice(SUPPLIER_PRICE)
                    .build();
    //@formatter=on

    @Test
    public void shouldReturnSupplyDTO() {

        Supply supply = SUPPLY_DTO_TRANSFORMER.supplyDTOToSupply(SUPPLY_DTO);

        assertEquals(SUPPLY_DTO.getSupplyId(), supply.getSupplyId());
        assertEquals(SUPPLY_DTO.getSupplier(), supply.getSupplier());
        assertEquals(SUPPLY_DTO.getSupplyDate(), supply.getSupplyDate());
        assertEquals(SUPPLY_DTO.getSupplierPrice(), supply.getSupplierPrice());
    }

    @Test
    public void shouldReturnSupply() {

        SupplyDTO supplyDto = SUPPLY_DTO_TRANSFORMER.supplyToSupplyDTO(SUPPLY);

        assertEquals(SUPPLY.getSupplyId(), supplyDto.getSupplyId());
        assertEquals(SUPPLY.getSupplier(), supplyDto.getSupplier());
        assertEquals(SUPPLY.getSupplyDate(), supplyDto.getSupplyDate());
        assertEquals(SUPPLY.getSupplierPrice(), supplyDto.getSupplierPrice());
    }
}