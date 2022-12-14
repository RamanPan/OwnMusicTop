package ru.ramanpan.topmusicgroupsweb.services.impl;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ru.ramanpan.topmusicgroupsweb.dto.MusicianDTO;
import ru.ramanpan.topmusicgroupsweb.exception.NotFoundException;
import ru.ramanpan.topmusicgroupsweb.model.Musician;
import ru.ramanpan.topmusicgroupsweb.model.Top;
import ru.ramanpan.topmusicgroupsweb.repositories.MusicianRepo;
import ru.ramanpan.topmusicgroupsweb.services.MusicianService;
import ru.ramanpan.topmusicgroupsweb.services.TopService;
import ru.ramanpan.topmusicgroupsweb.services.UserService;
import ru.ramanpan.topmusicgroupsweb.utils.Constants;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class MusicianServiceImpl implements MusicianService {
    private final MusicianRepo musicianRepo;
    private final TopService topService;
    private final UserService userService;
    private final ModelMapper modelMapper;

    @Override
    public List<Musician> findAllMusician() {
        return musicianRepo.findAll();
    }

    @Override
    public List<Musician> findAllMusicianByTop(Long topId) {
        Top top = topService.findTopById(topId);
        topService.addLook(top);
        return musicianRepo.findAllByTop(top);
    }

    @Override
    public Musician findById(Long id) {
        return musicianRepo.findById(id).orElseThrow(() -> new NotFoundException(Constants.MUSICIAN_NOT_FOUND));
    }

    @Override
    public List<MusicianDTO> mappedToListDTO(List<Musician> musicians) {
        List<MusicianDTO> dtoList = new ArrayList<>();
        for (Musician m : musicians) dtoList.add(modelMapper.map(m, MusicianDTO.class));
        return dtoList;
    }

    @Override
    public MusicianDTO mappedToDTO(Musician musician) {
        return modelMapper.map(musician,MusicianDTO.class);
    }

    @Override
    public void save(MusicianDTO musicianDTO) {
        Musician musician = new Musician();
        Top top = topService.findTopById(musicianDTO.getIdTop());
        userService.incrementCountAddedMusicians(top.getUser());
        musician.setName(musicianDTO.getName());
        musician.setAvatar(musicianDTO.getAvatar());
        musician.setBestSong(musician.getBestSong());
        musician.setDescription(musician.getDescription());
        musician.setGenre(musicianDTO.getGenre());
        musician.setPlace(musicianDTO.getPlace());
        musician.setDateCreated(LocalDate.now());
        musician.setTop(top);
        musicianRepo.save(musician);
    }

    @Override
    public void defaultSave(Musician musician) {
        musicianRepo.save(musician);
    }

    @Override
    public void update(MusicianDTO musicianDTO) {
        Musician musician = findById(musicianDTO.getId());
        Long topId = musicianDTO.getIdTop();
        musician.setName(musicianDTO.getName());
        musician.setAvatar(musicianDTO.getAvatar());
        musician.setBestSong(musician.getBestSong());
        musician.setDescription(musician.getDescription());
        musician.setGenre(musicianDTO.getGenre());
        musician.setPlace(musicianDTO.getPlace());
        musician.setDateUpdate(LocalDate.now());
        if (topId != null && !topId.equals(musician.getTop().getId())) musician.setTop(topService.findTopById(topId));
        musicianRepo.save(musician);
    }

    @Override
    public void delete(Long id) {
        musicianRepo.deleteById(id);
    }
}
