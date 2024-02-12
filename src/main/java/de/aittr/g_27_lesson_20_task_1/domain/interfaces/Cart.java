package de.aittr.g_27_lesson_20_task_1.domain.interfaces;

import java.util.List;

public interface Cart {

    int getId();

    void setId(int id);

    List<Product> getProducts();

    void setProducts(List<Product> products);

    void addProduct(Product product);

    void deleteProductById(int productId);

    void clear();

    double getTotalPrice();

    double getAveragePrice();
}