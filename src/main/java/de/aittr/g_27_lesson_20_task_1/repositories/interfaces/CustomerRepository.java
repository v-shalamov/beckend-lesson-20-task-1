package de.aittr.g_27_lesson_20_task_1.repositories.interfaces;

import de.aittr.g_27_lesson_20_task_1.domain.interfaces.Customer;

import java.util.List;

public interface CustomerRepository {

    Customer save(Customer customer);

    List<Customer> getAll();

    Customer getById(int id);

    Customer update(Customer customer);

    void deleteById(int id);
}