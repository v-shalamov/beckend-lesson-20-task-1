package de.aittr.g_27_lesson_20_task_1.domain.interfaces;

public interface Product {

    int getId();

    boolean isActive();

    String getName();

    double getPrice();

    void setId(int id);

    void setActive(boolean isActive);

    void setName(String name);

    void setPrice(double price);
}