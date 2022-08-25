package ru.ramanpan.topmusicgroupsweb.services;

import ru.ramanpan.topmusicgroupsweb.dto.AlbumDTO;
import ru.ramanpan.topmusicgroupsweb.model.Album;

import java.util.List;

public interface AlbumService {
    void save(AlbumDTO albumDTO);

    void defaultSave(Album album);

    void update(AlbumDTO albumDTO);

    List<AlbumDTO> mappedToListDTO(List<Album> albums);

    AlbumDTO mappedToDTO(Album albums);

    List<Album> findAll();

    List<Album> findAllAlbumsByTop(Long idTop);

    List<Album> findAlbumsByGroup(String nameGroup);

    Album findById(Long id);

    void delete(Long id);

    Album findByName(String name);
}
