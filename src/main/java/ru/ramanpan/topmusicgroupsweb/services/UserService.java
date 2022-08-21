package ru.ramanpan.topmusicgroupsweb.services;

import ru.ramanpan.topmusicgroupsweb.dto.UserDTO;
import ru.ramanpan.topmusicgroupsweb.model.User;

public interface UserService {
    void registration(UserDTO u);

    User findByEmailOrLogin(String data);

    void update(UserDTO u);

    void updatePassword(UserDTO u);

    User findById(Long id);

    void delete(Long id);
}
