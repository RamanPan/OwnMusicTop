package ru.ramanpan.topmusicgroupsweb.controllers;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ramanpan.topmusicgroupsweb.dto.AlbumDTO;
import ru.ramanpan.topmusicgroupsweb.model.Album;
import ru.ramanpan.topmusicgroupsweb.services.AlbumService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/album")
public class AlbumController {
    private final AlbumService albumService;

    @PostMapping("/add")
    public ResponseEntity.BodyBuilder addAlbum(@RequestBody @NonNull AlbumDTO albumDTO) {
        albumService.save(albumDTO);
        return ResponseEntity.ok();
    }

    @PostMapping("/update")
    public ResponseEntity.BodyBuilder updateAlbum(@RequestBody @NonNull AlbumDTO albumDTO) {
        albumService.update(albumDTO);
        return ResponseEntity.ok();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity.BodyBuilder deleteAlbum(@PathVariable("id") Long id) {
        albumService.delete(id);
        return ResponseEntity.ok();
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Album>> getAllAlbums() {
        return ResponseEntity.ok(albumService.findAll());
    }

    @GetMapping("/getByTop/{id}")
    public ResponseEntity<List<Album>> getAlbumsByTop(@PathVariable("id") Long idTop) {
        return ResponseEntity.ok(albumService.findAllAlbumsByTop(idTop));
    }

    @GetMapping("/getByMusician/{group}")
    public ResponseEntity<List<Album>> getAlbumsByGroup(@PathVariable("group") String group) {
        return ResponseEntity.ok(albumService.findAlbumsByGroup(group));
    }


}
