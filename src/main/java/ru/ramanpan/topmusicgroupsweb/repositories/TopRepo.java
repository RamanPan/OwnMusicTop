package ru.ramanpan.topmusicgroupsweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ramanpan.topmusicgroupsweb.model.Top;

import java.util.List;

public interface TopRepo extends JpaRepository<Top, Long> {
    List<Top> findAllByAuthor(String author);

}
