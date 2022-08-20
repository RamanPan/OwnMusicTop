package ru.ramanpan.topmusicgroupsweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ramanpan.topmusicgroupsweb.model.Token;

import java.util.Optional;

public interface TokenRepo extends JpaRepository<Token, Long> {
    Optional<Token> findByEmail(String email);
}
