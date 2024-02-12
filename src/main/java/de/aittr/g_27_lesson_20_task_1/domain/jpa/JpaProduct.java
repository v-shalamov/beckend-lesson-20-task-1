package de.aittr.g_27_lesson_20_task_1.domain.jpa;

import de.aittr.g_27_lesson_20_task_1.domain.interfaces.Product;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
@Table(name = "product")
public class JpaProduct implements Product {

    private Logger logger = LoggerFactory.getLogger(JpaCart.class);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    // Test - OK
    // TEST - X
    // Tes - X
    // test - X
    // TEst - X
    // Test@ - X
    // Test7 - X
    @Column(name = "name")
//    @NotNull
//    @NotBlank
    @Pattern(regexp = "[A-Z][a-z]{3,}")
    private String name;

    @Column(name = "price")
    @Max(90000)
    @Min(10)
    private double price;

    @Column(name = "is_active")
    private boolean isActive;

    public JpaProduct() {
        logger.info("Работа служебного конструктора, для Spring, для метода спорки продуктов");
    }

    public JpaProduct(int id, String name, double price, boolean isActive) {
        logger.info("Начало работы конструктора для продукта");
        this.id = id;
        this.name = name;
        this.price = price;
        this.isActive = isActive;
        logger.info("Конец работы конструктора для продукта");
    }

    @Override
    public int getId() {
        logger.info("Возвращение ID продукта");
        return id;
    }

    @Override
    public void setId(int id) {
        logger.info("изменение ID продукта");
        this.id = id;
    }

    @Override
    public String getName() {
        logger.info("Возвращение имени продукта");
        return name;
    }

    @Override
    public void setName(String name) {
        logger.info("изменение имени продукта");
        this.name = name;
    }

    @Override
    public double getPrice() {
        logger.info("Возвращение цены продукта");
        return price;
    }

    @Override
    public void setPrice(double price) {
        logger.info("изменение цены продукта");
        this.price = price;
    }

    @Override
    public boolean isActive() {
        logger.info("Проверка на активность продукта");
        return isActive;
    }

    @Override
    public void setActive(boolean active) {
        logger.info("Замена состояния продукта");
        isActive = active;
    }

    @Override
    public boolean equals(Object o) {
        logger.info("Начало сравнения продуктов");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JpaProduct that = (JpaProduct) o;
        return id == that.id && Double.compare(that.price, price) == 0 && isActive == that.isActive && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        logger.info("Получение hashCode продукта");
        return Objects.hash(id, name, price, isActive);
    }

    @Override
    public String toString() {
        logger.info("Вывод содержания объекта продукта в консоль");
        return "JpaProduct{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", isActive=" + isActive +
                '}';
    }
}