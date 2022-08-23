package ru.ramanpan.topmusicgroupsweb.controllers;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ramanpan.topmusicgroupsweb.dto.SongDTO;
import ru.ramanpan.topmusicgroupsweb.model.Song;
import ru.ramanpan.topmusicgroupsweb.services.SongService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/song")
public class SongController {
    private final SongService songService;

    @PostMapping("/add")
    public ResponseEntity.BodyBuilder addSong(@RequestBody @NonNull SongDTO songDTO) {
        songService.save(songDTO);
        return ResponseEntity.ok();
    }

    @PostMapping("/update")
    public ResponseEntity.BodyBuilder updateSong(@RequestBody @NonNull SongDTO songDTO) {
        songService.update(songDTO);
        return ResponseEntity.ok();
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Song>> getAllSongs() {
        return ResponseEntity.ok(songService.findAll());
    }

    @GetMapping("/getByTop/{id}")
    public ResponseEntity<List<Song>> getSongsByTop(@PathVariable("id") Long idTop) {
        return ResponseEntity.ok(songService.findAllByTop(idTop));
    }

    @GetMapping("/getByMusician/{group}")
    public ResponseEntity<List<Song>> getSongsByGroup(@PathVariable("group") String group) {
        return ResponseEntity.ok(songService.findSongsByGroup(group));
    }

    @GetMapping("/getByAlbum")
    public ResponseEntity<List<Song>> getSongsByAlbum(@RequestBody String album) {
        return ResponseEntity.ok(songService.findSongsByAlbum(album));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity.BodyBuilder deleteSong(@PathVariable("id") Long id) {
        songService.delete(id);
        return ResponseEntity.ok();
    }

}
