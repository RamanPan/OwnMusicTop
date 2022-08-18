package ru.ramanpan.topmusicgroupsweb.services;

import ru.ramanpan.topmusicgroupsweb.model.Token;

public interface TokenService {
    void save(Token token);

    String findTokenByEmail(String email);
}
