package edu.ICET.controller;


import edu.ICET.dto.Customer;
import edu.ICET.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {


   final CustomerService service;

    @PostMapping("/add")
    public void addCustomer(@RequestBody Customer customer){
        service.addCustomer(customer);

        System.out.println(customer);
    }

    @GetMapping("/getAll")
    public List<Customer> getAll(){

        return service.getAll();
    }

}
