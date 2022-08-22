package ru.ramanpan.topmusicgroupsweb.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.ramanpan.topmusicgroupsweb.dto.UserDTO;
import ru.ramanpan.topmusicgroupsweb.exception.NotFoundException;
import ru.ramanpan.topmusicgroupsweb.model.User;
import ru.ramanpan.topmusicgroupsweb.model.enums.Status;
import ru.ramanpan.topmusicgroupsweb.repositories.UserRepo;
import ru.ramanpan.topmusicgroupsweb.services.UserService;
import ru.ramanpan.topmusicgroupsweb.utils.Constants;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    private final BCryptPasswordEncoder encoder;

    @Override
    public void registration(UserDTO u) {
        User user = new User();
        user.setEmail(u.getEmail());
        user.setLogin(u.getLogin());
        user.setDescription(u.getDescription());
        user.setAvatar(" ");
        user.setStatus(Status.ACTIVE);
        user.setDateCreated(LocalDate.now());
        user.setPassword(encoder.encode(u.getPassword()));
        user.setCountAddedGroups(0);
        user.setCountCreatedTops(0);
        user.setCountAddedAlbums(0);
        user.setCountAddedSongs(0);
        userRepo.save(user);
    }

    @Override
    public User findByEmailOrLogin(String data) {
        return userRepo.findByLoginOrEmail(data, data).orElseThrow(() -> new NotFoundException(Constants.USER_NOT_FOUND));
    }

    @Override
    public void update(UserDTO u) {
        User user = findById(u.getId());
        user.setLogin(u.getLogin());
        user.setAvatar(u.getAvatar());
        user.setDescription(u.getDescription());
        user.setDateUpdate(LocalDate.now());
        user.setEmail(u.getEmail());
        userRepo.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepo.findById(id).orElseThrow(() -> new NotFoundException(Constants.USER_NOT_FOUND));
    }

    @Override
    public void updatePassword(UserDTO u) {
        User user = findById(u.getId());
        user.setPassword(encoder.encode(u.getPassword()));
        userRepo.save(user);
    }

    @Override
    public void delete(Long id) {
        userRepo.findById(id).orElseThrow(() -> new NotFoundException(Constants.USER_NOT_FOUND)).setStatus(Status.DELETED);
    }

    @Override
    public void incrementCountCreatedTops(User user) {
        user.setCountCreatedTops(user.getCountCreatedTops() + 1);
        userRepo.save(user);
    }

    @Override
    public void incrementCountAddedAlbums(User user) {
        user.setCountAddedAlbums(user.getCountAddedAlbums() + 1);
        userRepo.save(user);
    }

    @Override
    public void incrementCountAddedMusicians(User user) {
        user.setCountAddedGroups(user.getCountAddedGroups() + 1);
        userRepo.save(user);
    }

    @Override
    public void incrementCountAddedSongs(User user) {
        user.setCountAddedSongs(user.getCountAddedSongs() + 1);
        userRepo.save(user);
    }
}
