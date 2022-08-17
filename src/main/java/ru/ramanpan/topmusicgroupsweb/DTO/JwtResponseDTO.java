package ru.ramanpan.topmusicgroupsweb.DTO;

import lombok.Data;

@Data
public class JwtResponseDTO {
    private final String type = "Bearer";
    private String accessToken;
    private String refreshToken;
}
