package ru.ramanpan.topmusicgroupsweb.services;

import ru.ramanpan.topmusicgroupsweb.dto.UserDTO;
import ru.ramanpan.topmusicgroupsweb.model.User;

import java.util.List;

public interface UserService {
    void registration(UserDTO u);

    User findByEmailOrLogin(String data);

    void update(UserDTO u);


    void updatePassword(UserDTO u);

    User findById(Long id);

    void delete(Long id);

    List<User> findAll();

    void incrementCountCreatedTops(User user);

    void incrementCountAddedAlbums(User user);

    void incrementCountAddedMusicians(User user);

    void incrementCountAddedSongs(User user);
}
