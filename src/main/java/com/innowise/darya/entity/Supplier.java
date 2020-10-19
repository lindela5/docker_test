package com.innowise.darya.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "supplier")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Supplier {

    @Id
    private Long id;

    private String supplierName;
    private String address;
    private String phone;

}
