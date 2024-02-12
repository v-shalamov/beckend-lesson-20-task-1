package de.aittr.g_27_lesson_20_task_1.services.interfaces;

import de.aittr.g_27_lesson_20_task_1.domain.interfaces.Customer;

import java.util.List;

public interface CustomerService {

    Customer save(Customer customer);

    List<Customer> getAllActiveCustomers();

    Customer getActiveCustomerById(int id);

    void update(Customer customer);

    void deleteById(int id);

    void deleteByName(String name);

    void restoreById(int id);

    int getActiveCustomersCount();

    double getTotalCartPriceById(int customerId);

    double getAveragePriceById(int customerId);

    void addProductToCart(int customerId, int productId);

    void deleteProductFromCart(int customerId, int productId);

    void clearCartById(int customerId);
}