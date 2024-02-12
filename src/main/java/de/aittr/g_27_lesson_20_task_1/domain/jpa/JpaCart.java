package de.aittr.g_27_lesson_20_task_1.domain.jpa;

import de.aittr.g_27_lesson_20_task_1.domain.interfaces.Cart;
import de.aittr.g_27_lesson_20_task_1.domain.interfaces.Product;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Entity
@Table(name = "cart")
public class JpaCart implements Cart {

    private Logger logger = LoggerFactory.getLogger(JpaCart.class);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private JpaCustomer customer;

    @ManyToMany
    @JoinTable(
            name = "cart_product",
            joinColumns = @JoinColumn(name = "cart_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<JpaProduct> products;

    @Override
    public int getId() {
        logger.info("Возвращение ID корзины");
        return id;
    }

    @Override
    public void setId(int id) {
        logger.info("изменение ID корзины");
        this.id = id;
    }

//    public Customer getCustomer() {
//        return customer;
//    }
//
//    public void setCustomer(JpaCustomer customer) {
//        JpaCustomer entity = new JpaCustomer();
//        entity.setId(customer.getId());
//        entity.setName(customer.getName());
//        entity.setActive(customer.isActive());
//        entity.setCart(customer.getCart());
//        this.customer = entity;
//    }

    public JpaCustomer getCustomer() {
        logger.info("Возвращение JpaCustomer корзины");
        return customer;
    }

    public void setCustomer(JpaCustomer customer) {
        logger.info("изменение JpaCustomer корзины");
        this.customer = customer;
    }

    @Override
    public List<Product> getProducts() {
        logger.info("Возвращение продуктов корзины");
        return new ArrayList<>(products);
    }

    @Override
    public void setProducts(List<Product> products) {
        logger.info("изменение списка продуктов для корзины");
        this.products = products.stream().map(x -> {
            JpaProduct entity = new JpaProduct();
            entity.setId(x.getId());
            entity.setName(x.getName());
            entity.setActive(x.isActive());
            entity.setPrice(x.getPrice());
            return entity;
        }).toList();
    }

    @Override
    public void addProduct(Product product) {
        logger.info("Добавление продуктов в корзину");
    }

    @Override
    public void deleteProductById(int productId) {
        logger.info("Удаление продукта из корзины");
    }

    @Override
    public void clear() {

    }

    @Override
    public double getTotalPrice() {
        logger.info("Получение общей стоимости");
        return 0;
    }

    @Override
    public double getAveragePrice() {
        logger.info("Получение средней цены");
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        logger.info("Начало сравнения корзин");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JpaCart jpaCart = (JpaCart) o;
        return id == jpaCart.id && Objects.equals(customer, jpaCart.customer) && Objects.equals(products, jpaCart.products);
    }

    @Override
    public int hashCode() {
        logger.info("Получение hashCode корзины");
        return Objects.hash(id, customer, products);
    }

    @Override
    public String toString() {
        logger.info("Вывод содержания объекта корзины в консоль");
        return "JpaCart{" +
                "id=" + id +
                ", customer=" + customer +
                ", products=" + products +
                '}';
    }
}