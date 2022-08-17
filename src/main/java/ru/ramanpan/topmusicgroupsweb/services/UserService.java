package ru.ramanpan.topmusicgroupsweb.services;

import ru.ramanpan.topmusicgroupsweb.DTO.UserDTO;
import ru.ramanpan.topmusicgroupsweb.model.User;

public interface UserService {
    void registration(User user);

    User findByEmailOrLogin(String data);

    void updateLogin(UserDTO u);

    void delete(int id);
}
