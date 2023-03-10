package com.example.demo.customer;

import java.util.Arrays;
import java.util.List;

public class CustomerFakeRepository implements CustomerRepo{
    @Override
    public List<Customer> getCustomers() {
        return Arrays.asList(
                new Customer(1L, "Uzair Tariq", "password", "email@gmail.com"),
                new Customer(2L, "Ali Raza", "password", "email@gmail.com")
        );
    }
}