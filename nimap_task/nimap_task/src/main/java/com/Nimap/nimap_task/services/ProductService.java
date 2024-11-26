package com.Nimap.nimap_task.services;

import com.Nimap.nimap_task.dtos.CategoryResponseDto;
import com.Nimap.nimap_task.dtos.ProductResponseDto;
import com.Nimap.nimap_task.dtos.ResponseDto;
import com.Nimap.nimap_task.entities.Product;
import com.Nimap.nimap_task.interfaces.IProductService;
import com.Nimap.nimap_task.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService implements IProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public ResponseDto<List<ProductResponseDto>> getAllProducts() {
        List<Product> products = productRepository.findAll();

        if (!products.isEmpty()) {
            List<ProductResponseDto> productDtos = new ArrayList<>();
            for (Product product : products) {
                CategoryResponseDto categoryDto = new CategoryResponseDto(
                        product.getCategory().getId(),
                        product.getCategory().getCategoryName()
                );

                ProductResponseDto productDto = new ProductResponseDto(
                        product.getId(),
                        product.getProductName(),
                        product.getPrice(),
                        categoryDto
                );

                productDtos.add(productDto);
            }

            return new ResponseDto<>("Products fetched successfully", true, productDtos);
        } else {
            return new ResponseDto<>("No products found", false, null);
        }
    }

    public ResponseDto<ProductResponseDto> getProductById(UUID id)
    {
        Optional<Product> productOpt = productRepository.findById(id);

        if (productOpt.isPresent()) {
            Product product = productOpt.get();

            // Convert Product and Category to DTOs
            CategoryResponseDto categoryDto = new CategoryResponseDto(
                    product.getCategory().getId(),
                    product.getCategory().getCategoryName()
            );

            ProductResponseDto productDto = new ProductResponseDto(
                    product.getId(),
                    product.getProductName(),
                    product.getPrice(),
                    categoryDto
            );

            // Return the response with message and success flag
            return new ResponseDto<>("Product fetched successfully", true, productDto);
        } else {
            return new ResponseDto<>("Product not found", false, null);
        }
    }

    public Product updateProduct(UUID id, Product product)
    {
        Optional<Product> existingProductOpt = productRepository.findById(id);

        if (existingProductOpt.isPresent()) {
            Product existingProduct = existingProductOpt.get();

            existingProduct.setProductName(product.getProductName());
            existingProduct.setPrice(product.getPrice());
            existingProduct.setCategory(product.getCategory());
            return productRepository.save(existingProduct);
        }
        else
        {
            return null;
        }
    }

    public void deleteProduct(UUID id)
    {
        if (!productRepository.existsById(id))
        {
            throw new RuntimeException("Product not found with ID: " + id);
        }
        productRepository.deleteById(id);
    }
}
