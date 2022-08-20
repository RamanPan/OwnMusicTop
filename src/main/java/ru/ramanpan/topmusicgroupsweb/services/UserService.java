package ru.ramanpan.topmusicgroupsweb.services;

import ru.ramanpan.topmusicgroupsweb.dto.UserDTO;
import ru.ramanpan.topmusicgroupsweb.model.User;

public interface UserService {
    void registration(UserDTO u);

    User findByEmailOrLogin(String data);

    void updateLogin(UserDTO u);

    void delete(Long id);
}
