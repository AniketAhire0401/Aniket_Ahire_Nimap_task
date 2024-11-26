package com.Nimap.nimap_task.services;

import com.Nimap.nimap_task.entities.Category;
import com.Nimap.nimap_task.interfaces.ICategoryService;
import com.Nimap.nimap_task.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

@Service
public class CategoryService implements ICategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository)
    {
        this.categoryRepository = categoryRepository;
    }

    public Category addCategory(Category category)
    {
        Category savedData=categoryRepository.save(category);
         return savedData;
    }

    public Category getCategoryById(UUID id)
    {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with ID: " + id));
    }

    public Category updateCategory(UUID id, Category category)
    {
        Category existingCategory = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + id));

        existingCategory.setCategoryName(category.getCategoryName());

        return categoryRepository.save(existingCategory);
    }

    public void deleteCategory(UUID id)
    {
        categoryRepository.deleteById(id);
    }

    public Page<Category> getAllCategories(Pageable pageable)
    {
        return categoryRepository.findAll(pageable);
    }


}
