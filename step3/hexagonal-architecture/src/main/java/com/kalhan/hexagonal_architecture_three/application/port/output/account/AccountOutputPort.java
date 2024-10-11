package com.kalhan.hexagonal_architecture_three.application.port.output.account;

import com.kalhan.hexagonal_architecture_three.domain.account.model.Account;

public interface AccountOutputPort {
    Account retrieve(Long id);
}
