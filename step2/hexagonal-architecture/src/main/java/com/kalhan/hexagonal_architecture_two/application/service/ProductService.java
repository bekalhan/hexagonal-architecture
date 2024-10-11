package com.kalhan.hexagonal_architecture_two.application.service;

import com.kalhan.hexagonal_architecture_two.application.port.input.CreateProductUseCase;
import com.kalhan.hexagonal_architecture_two.application.port.output.ProductEventPublisher;
import com.kalhan.hexagonal_architecture_two.application.port.output.ProductOutputPort;
import com.kalhan.hexagonal_architecture_two.domain.event.ProductCreatedEvent;
import com.kalhan.hexagonal_architecture_two.domain.model.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
public class ProductService implements CreateProductUseCase {

    private final ProductOutputPort productOutputPort;
    private final ProductEventPublisher productEventPublisher;

    @Override
    public Product createProduct(Product product) {
        product = this.productOutputPort.saveProduct(product);
        this.productEventPublisher.publishProductCreatedEvent(
                new ProductCreatedEvent(product.getId())
        );
        return product;
    }
}
