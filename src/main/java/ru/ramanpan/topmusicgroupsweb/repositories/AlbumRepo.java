package ru.ramanpan.topmusicgroupsweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ramanpan.topmusicgroupsweb.model.Album;
import ru.ramanpan.topmusicgroupsweb.model.Top;

import java.util.List;
import java.util.Optional;

public interface AlbumRepo extends JpaRepository<Album, Long> {
    List<Album> findAllByMusicGroup(String musicGroup);

    List<Album> findAllByTop(Top top);

    Optional<Album> findByName(String name);
}
