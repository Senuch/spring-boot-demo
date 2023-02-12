package com.example.demo.customer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CustomerServiceTest {
    @Autowired
    private CustomerRepository customerRepository;
    private CustomerService underTest;

    @BeforeEach
    void setUp() {
        underTest = new CustomerService(customerRepository);
    }

    @AfterEach
    void tearDown() {
        customerRepository.deleteAll();
    }

    @Test
    void getCustomers() {
        Customer jamila = new Customer(
                1L,
                "Jamila",
                "123",
                "jamila@gmail.com"
        );
        Customer ali = new Customer(
                2L,
                "Ali",
                "123",
                "ali@gmail.com"
        );

        customerRepository.saveAll(Arrays.asList(jamila, ali));

        var customers = underTest.getCustomers();

        assertEquals(2, customers.size());
    }

    @Test
    void getCustomer() {
        Customer ali = new Customer(
                2L,
                "Ali",
                "123",
                "ali@gmail.com"
        );

        customerRepository.save(ali);

        var actual = underTest.getCustomer(2L);
        assertEquals(2L, actual.getId());
        assertEquals("Ali", actual.getName());
        assertEquals("123", actual.getPassword());
        assertEquals("ali@gmail.com", actual.getEmail());
    }
}