package ru.ramanpan.topmusicgroupsweb.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.time.LocalDate;


@Data
public class UserDTO {
    private Long id;

    private LocalDate dateCreated;

    private String login;

    @JsonIgnore
    private String password;

    private String avatar;

    private String description;

    private String email;
}
