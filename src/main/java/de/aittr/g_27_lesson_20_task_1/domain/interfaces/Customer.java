package de.aittr.g_27_lesson_20_task_1.domain.interfaces;

public interface Customer {

    int getId();

    boolean isActive();

    String getName();

    Cart getCart();

    void setId(int id);

    void setCart(Cart cart);

    void setActive(boolean isActive);

    void setName(String name);
}