package com.kalhan.hexagonal_architecture_two.infrastructure.output.persistence;

import com.kalhan.hexagonal_architecture_two.application.port.output.ProductOutputPort;
import com.kalhan.hexagonal_architecture_two.domain.model.Product;
import com.kalhan.hexagonal_architecture_two.infrastructure.output.persistence.entity.ProductEntity;
import com.kalhan.hexagonal_architecture_two.infrastructure.output.persistence.mapper.ProductPersistenceMapper;
import com.kalhan.hexagonal_architecture_two.infrastructure.output.persistence.repository.ProductRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProductPersistenceAdapter implements ProductOutputPort {

    private final ProductRepository productRepository;

    private final ProductPersistenceMapper productPersistenceMapper;

    @Override
    public Product saveProduct(final Product product) {
        ProductEntity productEntity = this.productPersistenceMapper.toProductEntity(product);
        productEntity = this.productRepository.save(productEntity);
        return this.productPersistenceMapper.toProduct(productEntity);
    }
}
