package com.kalhan.hexagonal_architecture_two.infrastructure.input.rest;


import com.kalhan.hexagonal_architecture_two.application.port.input.CreateProductUseCase;
import com.kalhan.hexagonal_architecture_two.domain.model.Product;
import com.kalhan.hexagonal_architecture_two.infrastructure.input.rest.data.request.ProductCreateRequest;
import com.kalhan.hexagonal_architecture_two.infrastructure.input.rest.data.response.ProductCreateResponse;
import com.kalhan.hexagonal_architecture_two.infrastructure.input.rest.mapper.ProductRestMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductRestAdapter {

    private final CreateProductUseCase createProductUseCase;

    private final ProductRestMapper productRestMapper;

    @PostMapping(value = "/create-product")
    public ResponseEntity<ProductCreateResponse> createProduct(@RequestBody @Valid final ProductCreateRequest productCreateRequest){
        // Request to domain
        Product product = this.productRestMapper.toProduct(productCreateRequest);

        product = this.createProductUseCase.createProduct(product);

        // Domain to response
        return new ResponseEntity<>(this.productRestMapper.toProductCreateResponse(product), HttpStatus.CREATED);
    }

}
