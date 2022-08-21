package ru.ramanpan.topmusicgroupsweb.services;

import ru.ramanpan.topmusicgroupsweb.dto.TopDTO;
import ru.ramanpan.topmusicgroupsweb.model.Top;

import java.util.List;

public interface TopService {

    void save(TopDTO topDTO);

    void defaultSave(Top top);

    void update(TopDTO topDTO);

    List<Top> findTopsByAuthor(String author);

    List<Top> findAll();

    void addLike(Long testId);

    void removeLike(Long testId);

    void addDislike(Long testId);

    void removeDislike(Long testId);

    void addLook(Long testId);

    void delete(Long id);

    Top findTopById(Long id);

}
