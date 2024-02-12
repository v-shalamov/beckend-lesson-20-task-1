package de.aittr.g_27_lesson_20_task_1.repositories.jpa;

import de.aittr.g_27_lesson_20_task_1.domain.jpa.JpaCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCustomerRepository extends JpaRepository<JpaCustomer, Integer> {
}