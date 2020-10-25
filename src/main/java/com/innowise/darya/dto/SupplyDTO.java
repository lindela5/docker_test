package com.innowise.darya.dto;

import com.innowise.darya.entity.Book;
import com.innowise.darya.entity.Supplier;
import com.innowise.darya.entity.Supply;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SupplyDTO {

    private Long supplyId;
    private Set<BookDTO> bookSupply;// = new HashSet<>();
    private Supplier supplier;
    private LocalDate supplyDate;
    private BigDecimal supplierPrice;

}