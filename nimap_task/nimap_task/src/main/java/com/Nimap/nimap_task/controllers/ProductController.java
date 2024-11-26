package com.Nimap.nimap_task.controllers;
import com.Nimap.nimap_task.dtos.ProductResponseDto;
import com.Nimap.nimap_task.dtos.ResponseDto;
import com.Nimap.nimap_task.entities.Product;
import com.Nimap.nimap_task.interfaces.IProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final IProductService productService;

    public ProductController(IProductService productService)
    {
        this.productService = productService;
    }

    //1.GET all the products
    @GetMapping
    public ResponseDto<List<ProductResponseDto>> getAllProducts()
    {
        return productService.getAllProducts();
    }
   //2 POST - create a new product
    @PostMapping
    public ResponseEntity<String> addProduct(@RequestBody Product product)
    {
        productService.addProduct(product);
        return ResponseEntity.ok("Saved Successfully");
    }
    //3.GET product by Id
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDto> getProductById(@PathVariable UUID id)
    {
        ProductResponseDto product = productService.getProductById(id).getData();
        return ResponseEntity.ok(product);
    }
    //3.PUT - update product by id
    @PutMapping("/{id}")
    public ResponseEntity<String> updateProduct(@RequestBody Product product, @PathVariable UUID id)
    {
        Product updatedProduct = productService.updateProduct(id, product);
        if (updatedProduct == null) {
            return ResponseEntity.status(404).body("Product not found");
        }
        return ResponseEntity.ok("Updated successfully");
    }
    //4/DELETE - Delete product by id
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable UUID id)
    {
        productService.deleteProduct(id);
        return ResponseEntity.ok("Deleted successfully");
    }

}