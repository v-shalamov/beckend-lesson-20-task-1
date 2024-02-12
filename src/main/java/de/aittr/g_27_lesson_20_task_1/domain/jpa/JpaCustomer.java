package de.aittr.g_27_lesson_20_task_1.domain.jpa;

import de.aittr.g_27_lesson_20_task_1.domain.interfaces.Cart;
import de.aittr.g_27_lesson_20_task_1.domain.interfaces.Customer;
import jakarta.persistence.*;

import java.util.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
@Table(name = "customer")
public class JpaCustomer implements Customer {

    private Logger logger = LoggerFactory.getLogger(JpaCart.class);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "is_active")
    private boolean isActive;

    @OneToOne(mappedBy = "customer")
    private JpaCart cart;

    @Override
    public int getId() {
        logger.info("Возвращение ID покупателя");
        return id;
    }

    @Override
    public void setId(int id) {
        logger.info("изменение ID покупателя");
        this.id = id;
    }

    @Override
    public String getName() {
        logger.info("Возвращение имени покупателя");
        return name;
    }

    @Override
    public void setName(String name) {
        logger.info("изменение имени покупателя");
        this.name = name;
    }

    @Override
    public boolean isActive() {
        logger.info("Проверка на активность покупателя");
        return isActive;
    }

    @Override
    public void setActive(boolean active) {
        logger.info("Замена состояния покупателя");
        isActive = active;
    }

    @Override
    public Cart getCart() {
        logger.info("Возвращение корзины покупателя");
        return cart;
    }

    @Override
    public void setCart(Cart cart) {
        logger.info("изменение корзины покупателя");
        JpaCart entity = new JpaCart();
        entity.setId(cart.getId());
        entity.setProducts(cart.getProducts());
        this.cart = entity;
    }

    @Override
    public boolean equals(Object o) {
        logger.info("Начало сравнения покупателей");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JpaCustomer that = (JpaCustomer) o;
        return id == that.id && isActive == that.isActive && Objects.equals(name, that.name) && Objects.equals(cart, that.cart);
    }

    @Override
    public int hashCode() {
        logger.info("Получение hashCode продукта");
        return Objects.hash(id, name, isActive, cart);
    }

    @Override
    public String toString() {
        logger.info("Вывод содержания объекта продукта в консоль");
        return "JpaCustomer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isActive=" + isActive +
                ", cart=" + cart +
                '}';
    }
}