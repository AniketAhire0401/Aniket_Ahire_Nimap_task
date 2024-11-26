package com.Nimap.nimap_task.interfaces;

import com.Nimap.nimap_task.entities.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface ICategoryService {
    Category addCategory(Category category);

    Page<Category> getAllCategories(Pageable pageable);

    Category getCategoryById(UUID id);

    Category updateCategory(UUID id, Category category);

    void deleteCategory(UUID id);
}
