package ru.ramanpan.topmusicgroupsweb.controllers;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;
import ru.ramanpan.topmusicgroupsweb.DTO.UserDTO;
import ru.ramanpan.topmusicgroupsweb.services.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    @GetMapping("/deleteUser")
    public ResponseEntity.BodyBuilder deleteUser(@RequestBody @NonNull Long id) {
        userService.delete(id);
        return ResponseEntity.ok();
    }
    @RequestMapping("/logout")
    public ResponseEntity.BodyBuilder logout(HttpServletRequest request, HttpServletResponse response) {
        SecurityContextLogoutHandler securityContextLogoutHandler = new SecurityContextLogoutHandler();
        securityContextLogoutHandler.logout(request, response, null);
        System.out.println("exit");
        return ResponseEntity.ok();
    }
}
