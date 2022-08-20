package ru.ramanpan.topmusicgroupsweb.services;

import ru.ramanpan.topmusicgroupsweb.dto.SongDTO;
import ru.ramanpan.topmusicgroupsweb.model.Song;

import java.util.List;

public interface SongService {
    void save(SongDTO songDTO);

    void defaultSave(Song song);

    void update(SongDTO songDTO);

    List<Song> findSongsByAlbum(String album);

    List<Song> findSongsByGroup(String group);

    List<Song> findAll();

    void delete(Long id);

    Song findById(Long id);

    List<Song> findAllByTop(Long idTop);
}
