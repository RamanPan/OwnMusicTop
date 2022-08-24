package ru.ramanpan.topmusicgroupsweb.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.ramanpan.topmusicgroupsweb.model.Top;
import ru.ramanpan.topmusicgroupsweb.model.User;

import java.util.List;

public interface TopRepo extends JpaRepository<Top, Long> {
    List<Top> findAllByAuthor(String author);

    List<Top> findAllByUser(User user);

    @Query("SELECT '*' FROM Top")
    Page<Top> findAllPage(Pageable pageable);
}
