package com.kalhan.hexagonal_architecture_three.application.port.input.common.usecase;

import com.kalhan.hexagonal_architecture_three.domain.common.model.UseCase;

public interface UseCaseHandler<E, T extends UseCase> {

    E handle(T useCase);
}
