package ru.ramanpan.topmusicgroupsweb.DTO;

import lombok.Data;


@Data
public class UserDTO {
    private Long id;

    private String login;

    private String password;

    private String avatar;

    private String description;

    private String email;
}
