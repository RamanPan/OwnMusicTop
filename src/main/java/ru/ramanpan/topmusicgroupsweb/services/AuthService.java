package ru.ramanpan.topmusicgroupsweb.services;

import lombok.NonNull;
import ru.ramanpan.topmusicgroupsweb.DTO.JwtRequestDTO;
import ru.ramanpan.topmusicgroupsweb.DTO.JwtResponseDTO;
import ru.ramanpan.topmusicgroupsweb.security.JwtAuthentication;

public interface AuthService {
    JwtResponseDTO login(@NonNull JwtRequestDTO authRequest);

    JwtResponseDTO getAccessToken(@NonNull String refreshToken);

    JwtResponseDTO getRefreshToken(@NonNull String refreshToken);

    JwtAuthentication getAuthInfo();
}
