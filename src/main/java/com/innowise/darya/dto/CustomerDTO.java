package com.innowise.darya.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {

    private Long customerId;
    private String firstName;
    private String lastName;
    private String address;
    private String phone;
    private String email;
}
