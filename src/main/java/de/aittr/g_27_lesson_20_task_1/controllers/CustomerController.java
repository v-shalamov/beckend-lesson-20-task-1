package de.aittr.g_27_lesson_20_task_1.controllers;

import de.aittr.g_27_lesson_20_task_1.domain.jdbc.CommonCustomer;
import de.aittr.g_27_lesson_20_task_1.domain.interfaces.Customer;
import de.aittr.g_27_lesson_20_task_1.services.interfaces.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @PostMapping
    public Customer save(@RequestBody CommonCustomer customer) {
        return service.save(customer);
    }

    @GetMapping
    public List<Customer> getAll() {
        return service.getAllActiveCustomers();
    }
}