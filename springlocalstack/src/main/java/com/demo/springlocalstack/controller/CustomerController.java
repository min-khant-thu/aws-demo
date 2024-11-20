package com.demo.springlocalstack.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.springlocalstack.dto.input.CustomerSqsInput;
import com.demo.springlocalstack.service.CustomerService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/register")
    public String custoemrRegisterForm(Model model) {
        model.addAttribute("customer", new CustomerSqsInput());
        return "customerRegister";
    }

    @PostMapping("/post")
    public String registerCustomer(@Valid @ModelAttribute("customer") CustomerSqsInput customerSqsInput,
            BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "customerRegister";
        }
        
        customerService.registerToSqs(customerSqsInput);
        return "test";
    }

}
