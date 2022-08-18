package ru.ramanpan.topmusicgroupsweb.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.ramanpan.topmusicgroupsweb.DTO.UserDTO;
import ru.ramanpan.topmusicgroupsweb.model.User;
import ru.ramanpan.topmusicgroupsweb.model.enums.Status;
import ru.ramanpan.topmusicgroupsweb.repositories.UserRepo;
import ru.ramanpan.topmusicgroupsweb.services.UserService;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    private final BCryptPasswordEncoder encoder;
    @Override
    public void registration(User user) {
        user.setStatus(Status.ACTIVE);
        user.setDateCreated(LocalDate.now());
        user.setPassword(encoder.encode(user.getPassword()));
        userRepo.save(user);
    }

    @SneakyThrows
    @Override
    public User findByEmailOrLogin(String data) {
        return userRepo.findByLoginOrEmail(data,data).orElseThrow(() ->new Exception("User not found"));
    }

    @Override
    public void updateLogin(UserDTO u) {
        User user = userRepo.findById(u.getId()).orElse(null);
        assert user != null;
        user.setLogin(u.getLogin());
        userRepo.save(user);

    }

    @Override
    public void delete(int id) {

    }
}
