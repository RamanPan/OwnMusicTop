package ru.ramanpan.topmusicgroupsweb.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
@Entity
@Table()
public class Song extends BasicEntity {
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String album;

    private Integer place;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "topId", nullable = false)
    @ToString.Exclude
    private Top top;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Song song = (Song) o;
        return getId() != null && Objects.equals(getId(), song.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
