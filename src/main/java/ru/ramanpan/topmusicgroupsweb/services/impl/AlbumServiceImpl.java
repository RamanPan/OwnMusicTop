package ru.ramanpan.topmusicgroupsweb.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ramanpan.topmusicgroupsweb.dto.AlbumDTO;
import ru.ramanpan.topmusicgroupsweb.exception.NotFoundException;
import ru.ramanpan.topmusicgroupsweb.model.Album;
import ru.ramanpan.topmusicgroupsweb.model.Top;
import ru.ramanpan.topmusicgroupsweb.repositories.AlbumRepo;
import ru.ramanpan.topmusicgroupsweb.services.AlbumService;
import ru.ramanpan.topmusicgroupsweb.services.TopService;
import ru.ramanpan.topmusicgroupsweb.services.UserService;
import ru.ramanpan.topmusicgroupsweb.utils.Constants;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class AlbumServiceImpl implements AlbumService {
    private final AlbumRepo albumRepo;
    private final TopService topService;
    private final UserService userService;

    @Override
    public void save(AlbumDTO albumDTO) {
        Album album = new Album();
        Top top = topService.findTopById(albumDTO.getIdTop());
        userService.incrementCountAddedAlbums(top.getUser());
        album.setAvatar(albumDTO.getAvatar());
        album.setMusicGroup(albumDTO.getMusicGroup());
        album.setName(albumDTO.getName());
        album.setPlace(albumDTO.getPlace());
        album.setDateCreated(LocalDate.now());
        album.setTop(top);
        albumRepo.save(album);
    }

    @Override
    public void defaultSave(Album album) {
        albumRepo.save(album);
    }

    @Override
    public void update(AlbumDTO albumDTO) {
        Long topId = albumDTO.getIdTop();
        Album album = findById(albumDTO.getId());
        album.setMusicGroup(albumDTO.getMusicGroup());
        album.setAvatar(albumDTO.getAvatar());
        album.setName(albumDTO.getName());
        album.setPlace(albumDTO.getPlace());
        album.setDateUpdate(LocalDate.now());
        if (topId != null && !topId.equals(album.getTop().getId()))
            album.setTop(topService.findTopById(albumDTO.getIdTop()));
        albumRepo.save(album);
    }

    @Override
    public List<Album> findAll() {
        return albumRepo.findAll();
    }

    @Override
    public List<Album> findAllAlbumsByTop(Long topId) {
        Top top = topService.findTopById(topId);
        topService.addLook(top);
        return albumRepo.findAllByTop(top);
    }

    @Override
    public List<Album> findAlbumsByGroup(String nameGroup) {
        return albumRepo.findAllByMusicGroup(nameGroup);
    }

    @Override
    public Album findById(Long id) {
        return albumRepo.findById(id).orElseThrow(() -> new NotFoundException(Constants.ALBUM_NOT_FOUND));
    }

    @Override
    public void delete(Long id) {
        albumRepo.deleteById(id);
    }

    @Override
    public Album findByName(String name) {
        return albumRepo.findByName(name).orElseThrow(() -> new NotFoundException(Constants.ALBUM_NOT_FOUND));
    }
}
