package ru.ramanpan.topmusicgroupsweb.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ramanpan.topmusicgroupsweb.dto.TopDTO;
import ru.ramanpan.topmusicgroupsweb.exception.NotFoundException;
import ru.ramanpan.topmusicgroupsweb.model.Top;
import ru.ramanpan.topmusicgroupsweb.model.enums.Type;
import ru.ramanpan.topmusicgroupsweb.repositories.TopRepo;
import ru.ramanpan.topmusicgroupsweb.services.TopService;
import ru.ramanpan.topmusicgroupsweb.utils.Constants;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class TopServiceImpl implements TopService {
    private final TopRepo topRepo;

    @Override
    public void save(TopDTO topDTO) {
        Top top = new Top();
        String type = topDTO.getType();
        top.setDateCreated(LocalDate.now());
        top.setAuthor(top.getAuthor());
        top.setAvatar(top.getAvatar());
        top.setDescription(top.getDescription());
        top.setHeader(top.getHeader());
        if("Группы".equals(type)) top.setType(Type.MUSICIANS);
        else if ("Альбомы".equals(type)) top.setType(Type.ALBUMS);
        else top.setType(Type.SONGS);
        topRepo.save(top);
    }

    @Override
    public void defaultSave(Top top) {
        topRepo.save(top);
    }

    @Override
    public void update(TopDTO topDTO) {
        Top top = findTopById(topDTO.getId());
        String type = topDTO.getType();
        top.setDateUpdate(LocalDate.now());
        top.setAvatar(top.getAvatar());
        top.setAuthor(top.getAuthor());
        top.setHeader(top.getHeader());
        top.setDescription(top.getDescription());
        if("Группы".equals(type)) top.setType(Type.MUSICIANS);
        else if ("Альбомы".equals(type)) top.setType(Type.ALBUMS);
        else top.setType(Type.SONGS);
        topRepo.save(top);
    }

    @Override
    public List<Top> findTopsByAuthor(String author) {
        return topRepo.findAllByAuthor(author);
    }

    @Override
    public List<Top> findAll() {
        return topRepo.findAll();
    }

    @Override
    public void delete(Long id) {
        topRepo.deleteById(id);
    }

    @Override
    public Top findTopById(Long id) {
        return topRepo.findById(id).orElseThrow(() -> new NotFoundException(Constants.TOP_NOT_FOUND));
    }
}
