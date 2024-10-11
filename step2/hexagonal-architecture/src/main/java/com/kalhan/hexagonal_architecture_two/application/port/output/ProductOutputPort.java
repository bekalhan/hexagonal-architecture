package com.kalhan.hexagonal_architecture_two.application.port.output;

import com.kalhan.hexagonal_architecture_two.domain.model.Product;

public interface ProductOutputPort {

    Product saveProduct(Product product);
}
