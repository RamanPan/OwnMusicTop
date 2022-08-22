package ru.ramanpan.topmusicgroupsweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ramanpan.topmusicgroupsweb.model.User;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findByLoginOrEmail(String login, String email);

}
