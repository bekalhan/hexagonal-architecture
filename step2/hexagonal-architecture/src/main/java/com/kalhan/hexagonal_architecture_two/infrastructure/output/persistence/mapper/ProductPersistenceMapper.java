package com.kalhan.hexagonal_architecture_two.infrastructure.output.persistence.mapper;

import com.kalhan.hexagonal_architecture_two.domain.model.Product;
import com.kalhan.hexagonal_architecture_two.infrastructure.output.persistence.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

@Service
public class ProductPersistenceMapper {

    public ProductEntity toProductEntity(Product product){
        return ProductEntity.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .build();
    }

    public Product toProduct(ProductEntity productEntity){
        return Product.builder()
                .id(productEntity.getId())
                .name(productEntity.getName())
                .description(productEntity.getDescription())
                .build();
    }
}
