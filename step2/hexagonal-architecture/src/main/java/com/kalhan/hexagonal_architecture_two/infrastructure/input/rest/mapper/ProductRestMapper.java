package com.kalhan.hexagonal_architecture_two.infrastructure.input.rest.mapper;

import com.kalhan.hexagonal_architecture_two.domain.model.Product;
import com.kalhan.hexagonal_architecture_two.infrastructure.input.rest.data.request.ProductCreateRequest;
import com.kalhan.hexagonal_architecture_two.infrastructure.input.rest.data.response.ProductCreateResponse;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

@Service
public class ProductRestMapper {

    public Product toProduct(ProductCreateRequest productCreateRequest){
        return Product.builder()
                .name(productCreateRequest.getName())
                .description(productCreateRequest.getDescription())
                .build();
    }

    public ProductCreateResponse toProductCreateResponse(Product product){
        return ProductCreateResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .build();
    }

}