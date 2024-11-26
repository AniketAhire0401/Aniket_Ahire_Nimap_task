package com.Nimap.nimap_task.controllers;
import com.Nimap.nimap_task.entities.Category;
import com.Nimap.nimap_task.interfaces.ICategoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@RequestMapping("/api/categories")
public class CategoryController
{
    private final ICategoryService categoryService;

    public CategoryController(ICategoryService categoryService)
    {
        this.categoryService = categoryService;
    }
    // 1) GET all the categories
    @GetMapping
    public ResponseEntity<Page<Category>> getAllCategories(@RequestParam(defaultValue = "0") int page)
    {
        PageRequest pageRequest = PageRequest.of(page, 10);
        Page<Category> categories = categoryService.getAllCategories(pageRequest);
        return ResponseEntity.ok(categories);
    }
    // 2) POST - create a new category
    @PostMapping
    public ResponseEntity<String> addCategory(@RequestBody Category category)
    {
        categoryService.addCategory(category);
        return ResponseEntity.ok("Saved Successfully");
    }
    // 3) GET category by Id
    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable UUID id)
    {
        Category category = categoryService.getCategoryById(id);
        return ResponseEntity.ok(category);
    }
    // 4) PUT - update category by id
    @PutMapping("/{id}")
    public ResponseEntity<String> updateCategory(@PathVariable UUID id, @RequestBody Category category)
    {
        categoryService.updateCategory(id, category);
        return ResponseEntity.ok("Update Successfully");
    }
    // 5) DELETE - Delete category by id
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable UUID id)
    {
        categoryService.deleteCategory(id);
        return ResponseEntity.ok("Deleted Successfully");
    }

}
