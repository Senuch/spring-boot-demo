package com.example.demo.customer;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

@RequestMapping(path = "api/v2/customers")
@RestController
@AllArgsConstructor
public class CustomerControllerV2 {
    private final CustomerService customerService;

    @GetMapping(value = "all")
    List<Customer> getCustomers(){
        return customerService.getCustomers();
    }

    @GetMapping(path = "{customerId}")
    Customer getCustomer(@PathVariable("customerId") long id){
        return customerService.getCustomer(id);
    }

    @PostMapping
    void createNewCustomer(@Valid @RequestBody Customer customer){
        System.out.println("POST REQUEST...");
        System.out.println(customer);
    }

    @PutMapping
    void updateCustomer(@RequestBody Customer customer){
        System.out.println("PUT REQUEST...");
        System.out.println(customer);
    }

    @DeleteMapping(path = "{customerId}")
    void deleteCustomer(@PathVariable("customerId") long id){
        System.out.println("DELETE REQUEST...");
        System.out.println(id);
    }
}