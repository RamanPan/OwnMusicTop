package ru.ramanpan.topmusicgroupsweb.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Table()
@Entity
@ToString
@Getter
@RequiredArgsConstructor
@Setter
public class Musician extends BasicEntity {
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String genre;

    private String avatar;

    private String bestSong;

    @Column(length = 1000)
    private String description;

    private Integer place;

    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    @JoinColumn(name = "topId",nullable = false)
    @ToString.Exclude
    private Top top;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Musician musician = (Musician) o;
        return getId() != null && Objects.equals(getId(), musician.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
