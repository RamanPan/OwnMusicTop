package ru.ramanpan.topmusicgroupsweb.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ramanpan.topmusicgroupsweb.exception.NotFoundException;
import ru.ramanpan.topmusicgroupsweb.model.Token;
import ru.ramanpan.topmusicgroupsweb.repositories.TokenRepo;
import ru.ramanpan.topmusicgroupsweb.services.TokenService;

@Service
@RequiredArgsConstructor
public class TokenServiceImpl implements TokenService {
    private final TokenRepo tokenRepo;
    @Override
    public void save(Token token) {
        tokenRepo.save(token);
    }

    @Override
    public String findTokenByEmail(String email) {
        return tokenRepo.findByEmail(email).orElseThrow(() -> new NotFoundException("token not found")).getToken();
    }
}
