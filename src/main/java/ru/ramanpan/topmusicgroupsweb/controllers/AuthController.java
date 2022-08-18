package ru.ramanpan.topmusicgroupsweb.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ramanpan.topmusicgroupsweb.DTO.JwtRefreshRequestDTO;
import ru.ramanpan.topmusicgroupsweb.DTO.JwtRequestDTO;
import ru.ramanpan.topmusicgroupsweb.DTO.JwtResponseDTO;
import ru.ramanpan.topmusicgroupsweb.services.AuthService;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<JwtResponseDTO> login(@RequestBody JwtRequestDTO authRequest) {
        return ResponseEntity.ok(authService.login(authRequest));
    }
    @PostMapping("/access")
    public ResponseEntity<JwtResponseDTO> getAccessToken(@RequestBody JwtRefreshRequestDTO refreshRequest) {
        return ResponseEntity.ok(authService.getAccessToken(refreshRequest.getRefreshToken()));
    }
    @PostMapping("/refresh")
    public ResponseEntity<JwtResponseDTO> getRefreshToken(@RequestBody JwtRefreshRequestDTO refreshRequest) {
        return ResponseEntity.ok(authService.getRefreshToken(refreshRequest.getRefreshToken()));
    }
}
