package ru.ramanpan.topmusicgroupsweb.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ramanpan.topmusicgroupsweb.dto.SongDTO;
import ru.ramanpan.topmusicgroupsweb.exception.NotFoundException;
import ru.ramanpan.topmusicgroupsweb.model.Song;
import ru.ramanpan.topmusicgroupsweb.repositories.SongRepo;
import ru.ramanpan.topmusicgroupsweb.services.SongService;
import ru.ramanpan.topmusicgroupsweb.services.TopService;
import ru.ramanpan.topmusicgroupsweb.utils.Constants;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class SongServiceImpl implements SongService {
    private SongRepo songRepo;
    private TopService topService;

    @Override
    public void save(SongDTO songDTO) {
        Song song = new Song();
        song.setName(songDTO.getName());
        song.setAlbum(songDTO.getAlbum());
        song.setAuthor(songDTO.getAuthor());
        song.setDateCreated(LocalDate.now());
        song.setPlace(songDTO.getPlace());
        song.setTop(topService.findTopById(songDTO.getIdTop()));
        songRepo.save(song);
    }

    @Override
    public void defaultSave(Song song) {
        songRepo.save(song);
    }

    @Override
    public void update(SongDTO songDTO) {
        Long topId = songDTO.getId();
        Song song = findById(songDTO.getId());
        song.setAlbum(songDTO.getAlbum());
        song.setName(songDTO.getName());
        song.setAuthor(songDTO.getAuthor());
        song.setDateCreated(LocalDate.now());
        song.setPlace(songDTO.getPlace());
        if (topId != null && !topId.equals(song.getTop().getId())) song.setTop(topService.findTopById(songDTO.getIdTop()));
        songRepo.save(song);
    }

    @Override
    public List<Song> findSongsByAlbum(String album) {
        return songRepo.findAllByAlbum(album);
    }

    @Override
    public List<Song> findSongsByGroup(String group) {
        return songRepo.findAllByAuthor(group);
    }

    @Override
    public List<Song> findAll() {
        return songRepo.findAll();
    }

    @Override
    public void delete(Long id) {
        songRepo.deleteById(id);
    }

    @Override
    public Song findById(Long id) {
        return songRepo.findById(id).orElseThrow(() -> new NotFoundException(Constants.SONG_NOT_FOUND));
    }

    @Override
    public List<Song> findAllByTop(Long idTop) {
        return songRepo.findAllByTop(topService.findTopById(idTop));
    }
}
