package com.kalhan.hexagonal_architecture_two.infrastructure.output.persistence.repository;

import com.kalhan.hexagonal_architecture_two.infrastructure.output.persistence.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity,Long> {
}
