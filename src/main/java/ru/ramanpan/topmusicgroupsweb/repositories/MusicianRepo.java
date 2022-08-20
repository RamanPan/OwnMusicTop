package ru.ramanpan.topmusicgroupsweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ramanpan.topmusicgroupsweb.model.Musician;
import ru.ramanpan.topmusicgroupsweb.model.Top;

import java.util.List;

public interface MusicianRepo extends JpaRepository<Musician, Long> {
    List<Musician> findAllByTop(Top top);
}
