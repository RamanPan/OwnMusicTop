package ru.ramanpan.topmusicgroupsweb.services;

import ru.ramanpan.topmusicgroupsweb.dto.MusicianDTO;
import ru.ramanpan.topmusicgroupsweb.model.Musician;

import java.util.List;

public interface MusicianService {
    List<Musician> findAllMusician();

    List<Musician> findAllMusicianByTop(Long topId);

    Musician findById(Long id);

    void save(MusicianDTO musicianDTO);

    void defaultSave(Musician musician);

    void update(MusicianDTO musicianDTO);

    void delete(Long id);
}
