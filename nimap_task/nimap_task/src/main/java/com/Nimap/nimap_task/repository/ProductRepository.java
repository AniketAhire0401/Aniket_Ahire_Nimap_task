package com.Nimap.nimap_task.repository;
import com.Nimap.nimap_task.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
}
