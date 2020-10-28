package com.innowise.darya.dto;

import com.innowise.darya.entity.Book;
import com.innowise.darya.entity.Supplier;
import com.innowise.darya.entity.Supply;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(exclude = {"bookSupply"})
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