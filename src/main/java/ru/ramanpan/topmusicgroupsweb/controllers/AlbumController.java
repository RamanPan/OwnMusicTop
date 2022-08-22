package ru.ramanpan.topmusicgroupsweb.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ramanpan.topmusicgroupsweb.model.Album;
import ru.ramanpan.topmusicgroupsweb.services.AlbumService;

@RestController
@AllArgsConstructor
@RequestMapping("/api/album")
public class AlbumController {
    private final AlbumService albumService;
}
