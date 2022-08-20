package ru.ramanpan.topmusicgroupsweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ramanpan.topmusicgroupsweb.model.Musician;

public interface MusicianRepo extends JpaRepository<Musician, Long> {
}
