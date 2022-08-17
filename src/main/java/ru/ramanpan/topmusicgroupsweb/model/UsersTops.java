package ru.ramanpan.topmusicgroupsweb.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "usersTop")
public class UsersTops extends BasicEntity {
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "users", nullable = false)
    @ToString.Exclude
    private User users;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "top", nullable = false)
    @ToString.Exclude
    private Top top;

    private Integer likes;

    private Integer dislikes;
}
