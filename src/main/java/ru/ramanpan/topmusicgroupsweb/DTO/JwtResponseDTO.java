package ru.ramanpan.topmusicgroupsweb.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JwtResponseDTO {
    private final String type = "Bearer";
    private Long ID;
    private String accessToken;
    private String refreshToken;
}
