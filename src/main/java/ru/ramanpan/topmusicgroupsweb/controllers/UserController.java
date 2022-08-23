package ru.ramanpan.topmusicgroupsweb.controllers;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;
import ru.ramanpan.topmusicgroupsweb.dto.UserDTO;
import ru.ramanpan.topmusicgroupsweb.model.User;
import ru.ramanpan.topmusicgroupsweb.services.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    @PostMapping("/registration")
    public ResponseEntity.BodyBuilder registration(@RequestBody @NonNull UserDTO u) {
        userService.registration(u);
        return ResponseEntity.ok();
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity.BodyBuilder deleteUser(@PathVariable("id") Long id) {
        userService.delete(id);
        return ResponseEntity.ok();
    }

    @PostMapping("/update")
    public ResponseEntity.BodyBuilder updateUser(@RequestBody UserDTO u) {
        userService.update(u);
        return ResponseEntity.ok();
    }

    @PostMapping("/updatePassword")
    public ResponseEntity.BodyBuilder updatePassword(@RequestBody UserDTO u) {
        userService.updatePassword(u);
        return ResponseEntity.ok();
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.findAll());
    }

    @RequestMapping("/logout")
    public ResponseEntity.BodyBuilder logout(HttpServletRequest request, HttpServletResponse response) {
        SecurityContextLogoutHandler securityContextLogoutHandler = new SecurityContextLogoutHandler();
        securityContextLogoutHandler.logout(request, response, null);
        return ResponseEntity.ok();
    }
}
