package ru.ramanpan.topmusicgroupsweb.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.ramanpan.topmusicgroupsweb.DTO.UserDTO;
import ru.ramanpan.topmusicgroupsweb.exception.NotFoundException;
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

    @SneakyThrows
    @Override
    public User findByEmailOrLogin(String data) {
        return userRepo.findByLoginOrEmail(data,data).orElseThrow(() -> new NotFoundException("User not found"));
    }

    @Override
    public void updateLogin(UserDTO u) {
        User user = userRepo.findById(u.getId()).orElseThrow(() -> new NotFoundException("User not found"));
        user.setLogin(u.getLogin());
        userRepo.save(user);

    }

    @Override
    public void delete(Long id) {
        userRepo.findById(id).orElseThrow(() -> new NotFoundException("User not found")).setStatus(Status.DELETED);
    }
}
