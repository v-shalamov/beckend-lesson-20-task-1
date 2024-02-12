package de.aittr.g_27_lesson_20_task_1.services.mapping;

import de.aittr.g_27_lesson_20_task_1.domain.dto.ProductDto;
import de.aittr.g_27_lesson_20_task_1.domain.interfaces.Product;
import de.aittr.g_27_lesson_20_task_1.domain.jdbc.CommonProduct;
import de.aittr.g_27_lesson_20_task_1.domain.jpa.JpaProduct;
import org.springframework.stereotype.Service;

@Service
public class ProductMappingService {

    public ProductDto mapEntityToDto(Product product) {
        int id = product.getId();
        String name = product.getName();
        double price = product.getPrice();
        return new ProductDto(id, name, price);
    }

    public JpaProduct mapDtoToEntity(ProductDto product) {
        int id = product.getId();
        String name = product.getName();
        double price = product.getPrice();
        return new JpaProduct(id, name, price, true);
    }

    public CommonProduct mapDtoToCommonProduct(ProductDto product) {
        int id = product.getId();
        String name = product.getName();
        double price = product.getPrice();
        return new CommonProduct(id, name, price);
    }
}