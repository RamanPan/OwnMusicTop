package ru.ramanpan.topmusicgroupsweb.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.ramanpan.topmusicgroupsweb.dto.TopDTO;
import ru.ramanpan.topmusicgroupsweb.model.Top;

import java.util.List;

public interface TopService {

    void save(TopDTO topDTO);

    void defaultSave(Top top);

    void update(TopDTO topDTO);

    List<Top> findTopsByAuthor(String author);

    List<Top> findTopsByUser(Long userId);

    List<Top> findAll();

    Page<Top> findAllWithPagination(Pageable pageable);

    List<TopDTO> mappedToListDTO(List<Top> tops);

    TopDTO mappedToDTO(Top top);

    void addLike(Long idTop);

    void removeLike(Long idTop);

    void addDislike(Long idTop);

    void removeDislike(Long idTop);

    void addLook(Top top);

    void delete(Long id);

    Top findTopById(Long id);

}
