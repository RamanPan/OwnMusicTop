package ru.ramanpan.topmusicgroupsweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ramanpan.topmusicgroupsweb.model.Album;

public interface AlbumRepo extends JpaRepository<Album, Long> {
}
