package de.aittr.g_27_lesson_20_task_1.repositories.jpa;

import de.aittr.g_27_lesson_20_task_1.domain.jpa.JpaProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaProductRepository extends JpaRepository<JpaProduct, Integer> {
}