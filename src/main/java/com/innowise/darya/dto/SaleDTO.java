package com.innowise.darya.dto;

import com.innowise.darya.entity.BookEntity;
import com.innowise.darya.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleDTO {

    private Long saleId;
    private BookEntity bookEntity;
    private Customer customer;
    private LocalDate saleDate;
    private int quantity;
    private int amount;
}
