package com.kalhan.hexagonal_architecture_two.infrastructure.input.rest.data.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;


@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductCreateRequest {

    @NotEmpty(message = "Name may not be empty")
    private String name;

    @NotEmpty(message = "Description may not be empty")
    private String description;

}