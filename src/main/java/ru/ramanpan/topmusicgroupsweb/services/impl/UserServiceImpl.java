package ru.ramanpan.topmusicgroupsweb.services.impl;

import lombok.RequiredArgsConstructor;
import ru.ramanpan.topmusicgroupsweb.DTO.UserDTO;
import ru.ramanpan.topmusicgroupsweb.model.User;
import ru.ramanpan.topmusicgroupsweb.model.enums.Status;
import ru.ramanpan.topmusicgroupsweb.repositories.UserRepo;
import ru.ramanpan.topmusicgroupsweb.services.UserService;

import java.time.LocalDate;

@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;

    @Override
    public void registration(User user) {
        user.setStatus(Status.ACTIVE);
        user.setDateCreated(LocalDate.now());
        userRepo.save(user);
    }

    @Override
    public User findByEmailOrLogin(String data) {
        return userRepo.findByLoginOrEmail(data).orElse(null);
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
