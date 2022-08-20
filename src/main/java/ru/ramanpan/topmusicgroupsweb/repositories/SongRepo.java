package ru.ramanpan.topmusicgroupsweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ramanpan.topmusicgroupsweb.model.Song;
import ru.ramanpan.topmusicgroupsweb.model.Top;

import java.util.List;

public interface SongRepo extends JpaRepository<Song, Long> {

    List<Song> findAllByTop(Top top);

    List<Song> findAllByAuthor(String author);

    List<Song> findAllByAlbum(String album);

}
