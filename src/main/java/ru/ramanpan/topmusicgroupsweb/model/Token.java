package ru.ramanpan.topmusicgroupsweb.model;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table
@Getter
@Setter
@RequiredArgsConstructor
public class Token {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String token;

    public Token(String email, String refreshToken) {
        this.email = email;
        this.token = refreshToken;
    }
}
