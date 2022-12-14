package ru.ramanpan.topmusicgroupsweb.services;

import lombok.NonNull;
import ru.ramanpan.topmusicgroupsweb.dto.JwtRequestDTO;
import ru.ramanpan.topmusicgroupsweb.dto.JwtResponseDTO;
import ru.ramanpan.topmusicgroupsweb.security.JwtAuthentication;

public interface AuthService {
    JwtResponseDTO login(@NonNull JwtRequestDTO authRequest);

    JwtResponseDTO getAccessToken(@NonNull String refreshToken);

    JwtResponseDTO getRefreshToken(@NonNull String refreshToken);

    JwtAuthentication getAuthInfo();
}
