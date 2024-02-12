package de.aittr.g_27_lesson_20_task_1.repositories.interfaces;

import de.aittr.g_27_lesson_20_task_1.domain.interfaces.Product;

import java.util.List;

public interface ProductRepository {

    Product save(Product product);

    List<Product> getAll();

    Product getById(int id);

    Product update(Product product);

    void deleteById(int id);
}