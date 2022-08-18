package ru.ramanpan.topmusicgroupsweb.services.impl;

import io.jsonwebtoken.Claims;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.ramanpan.topmusicgroupsweb.DTO.JwtRequestDTO;
import ru.ramanpan.topmusicgroupsweb.DTO.JwtResponseDTO;
import ru.ramanpan.topmusicgroupsweb.model.Token;
import ru.ramanpan.topmusicgroupsweb.model.User;
import ru.ramanpan.topmusicgroupsweb.security.JwtAuthentication;
import ru.ramanpan.topmusicgroupsweb.security.JwtProvider;
import ru.ramanpan.topmusicgroupsweb.services.AuthService;
import ru.ramanpan.topmusicgroupsweb.services.TokenService;
import ru.ramanpan.topmusicgroupsweb.services.UserService;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserService userService;
    private final TokenService tokenService;
    private final JwtProvider jwtProvider;
    private final BCryptPasswordEncoder encoder;

    @SneakyThrows
    @Override
    public JwtResponseDTO login(@NonNull JwtRequestDTO authRequest) {
        User user = userService.findByEmailOrLogin(authRequest.getEmail());
        if (user.getPassword().equals(encoder.encode(authRequest.getPassword()))) {
            String accessToken = jwtProvider.generateAccessToken(user);
            String refreshToken = jwtProvider.generateRefreshToken(user);
            tokenService.save(new Token(user.getEmail(), refreshToken));
            return new JwtResponseDTO(accessToken, refreshToken);
        } else throw new Exception("Wrong password");
    }

    @Override
    public JwtResponseDTO getAccessToken(@NonNull String refreshToken) {
        if (jwtProvider.validateRefreshToken(refreshToken)) {
            Claims claims = jwtProvider.getRefreshClaims(refreshToken);
            String email = claims.getSubject();
            String savedRefreshToken = tokenService.findTokenByEmail(email);
            if (savedRefreshToken != null && savedRefreshToken.equals(refreshToken)) {
                User user = userService.findByEmailOrLogin(email);
                return new JwtResponseDTO(jwtProvider.generateAccessToken(user), null);
            }
        }
        return new JwtResponseDTO(null, null);
    }

    @SneakyThrows
    @Override
    public JwtResponseDTO getRefreshToken(@NonNull String refreshToken) {
        if (jwtProvider.validateRefreshToken(refreshToken)) {
            Claims claims = jwtProvider.getRefreshClaims(refreshToken);
            String email = claims.getSubject();
            String savedRefreshToken = tokenService.findTokenByEmail(email);
            if (savedRefreshToken != null && savedRefreshToken.equals(refreshToken)) {
                User user = userService.findByEmailOrLogin(email);
                String accessToken = jwtProvider.generateAccessToken(user);
                String newRefreshToken = jwtProvider.generateRefreshToken(user);
                tokenService.save(new Token(user.getEmail(), newRefreshToken));
                return new JwtResponseDTO(accessToken, refreshToken);
            }
        }
        throw new Exception("Invalid refresh token");
    }

    @Override
    public JwtAuthentication getAuthInfo() {
        return (JwtAuthentication) SecurityContextHolder.getContext().getAuthentication();
    }
}
