package ru.ramanpan.topmusicgroupsweb.services;

import ru.ramanpan.topmusicgroupsweb.dto.MusicianDTO;
import ru.ramanpan.topmusicgroupsweb.model.Musician;
import ru.ramanpan.topmusicgroupsweb.model.Top;

import java.util.List;

public interface MusicianService {
    List<Musician> findAllMusician();

    List<Musician> findAllMusicianByTop(Top top);

    Musician findById(Long id);

    void save(MusicianDTO musicianDTO);

    void defaultSave(Musician musician);

    void update(MusicianDTO musicianDTO);

    void delete(Long id);
}
