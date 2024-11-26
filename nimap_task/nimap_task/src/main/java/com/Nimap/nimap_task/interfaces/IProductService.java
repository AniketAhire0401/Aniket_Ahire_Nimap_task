package com.Nimap.nimap_task.interfaces;

import com.Nimap.nimap_task.dtos.ProductResponseDto;
import com.Nimap.nimap_task.dtos.ResponseDto;
import com.Nimap.nimap_task.entities.Product;

import java.util.List;
import java.util.UUID;

public interface IProductService {
    Product addProduct(Product product);

    ResponseDto<List<ProductResponseDto>> getAllProducts();

    ResponseDto<ProductResponseDto> getProductById(UUID id);

    Product updateProduct(UUID id, Product product);

    void deleteProduct(UUID id);
}
