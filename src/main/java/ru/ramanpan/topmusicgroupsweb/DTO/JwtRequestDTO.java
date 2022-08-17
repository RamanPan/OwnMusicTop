package ru.ramanpan.topmusicgroupsweb.DTO;

import lombok.Data;

@Data
public class JwtRequestDTO {
    private String email;
    private String password;
}
