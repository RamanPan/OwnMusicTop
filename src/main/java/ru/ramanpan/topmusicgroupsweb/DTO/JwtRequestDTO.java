package ru.ramanpan.topmusicgroupsweb.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JwtRequestDTO {
    private String email;
    private String password;
}
