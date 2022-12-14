package ru.ramanpan.topmusicgroupsweb.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import ru.ramanpan.topmusicgroupsweb.model.enums.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table()
public class Top extends BasicEntity {
    @Column(nullable = false)
    private String header;

    @Column(length = 1000)
    private String description;
    @Column(nullable = false)
    private String author;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private Type type;

    private String avatar;

    private Integer likes;

    private Integer dislikes;

    private Integer countLooks;

    @OneToMany(mappedBy = "top", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Musician> musicians = new ArrayList<>();

    @OneToMany(mappedBy = "top", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Album> albums = new ArrayList<>();

    @OneToMany(mappedBy = "top", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Song> songs = new ArrayList<>();

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", nullable = false)
    @ToString.Exclude
    private User user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Top top = (Top) o;
        return getId() != null && Objects.equals(getId(), top.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
