package ru.ramanpan.topmusicgroupsweb.dto;

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
