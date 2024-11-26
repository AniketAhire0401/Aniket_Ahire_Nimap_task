package com.Nimap.nimap_task.repository;
import com.Nimap.nimap_task.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {
}
