package com.innowise.darya.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
@Table(name = "sales")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sale {
    @Id
    private Long saleId;

    @NotBlank
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="book_id")
    private BookEntity bookEntity;

    @NotBlank
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="customer_id")
    private Customer customer;

    @Column(name = "sale_date")
    private LocalDate saleDate;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "amount")
    private int amount;

}
