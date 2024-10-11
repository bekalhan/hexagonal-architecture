package com.kalhan.hexagonal_architecture_two.application.port.input;

import com.kalhan.hexagonal_architecture_two.domain.model.Product;

public interface CreateProductUseCase {
    Product createProduct(Product product);
}
