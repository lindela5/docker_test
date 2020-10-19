package com.innowise.darya.dto;

import com.innowise.darya.entity.Book;
import com.innowise.darya.entity.Supplier;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SupplyDTO {

    private Long supplyId;
    private Set<Book> bookSupply = new HashSet<>();
    private Supplier supplier;
    private LocalDate supplyDate;
    private BigDecimal supplierPrice;

}