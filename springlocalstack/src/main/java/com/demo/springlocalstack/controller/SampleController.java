package com.demo.springlocalstack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.springlocalstack.dto.output.CustomerSqsOutput;
import com.demo.springlocalstack.service.CustomerService;

@RestController
public class SampleController {
    
    @Autowired
    private CustomerService customerService;

    @GetMapping("/")
    public List<CustomerSqsOutput> getCustomers() {
        List<CustomerSqsOutput> response = customerService.receiveMessageFromSqs();
        return response;
    }
}
