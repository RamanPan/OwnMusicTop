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

    @GetMapping("/getByTop")
    public ResponseEntity<List<Song>> getSongsByTop(@RequestBody @NonNull Long idTop) {
        return ResponseEntity.ok(songService.findAllByTop(idTop));
    }

    @GetMapping("/getByMusician")
    public ResponseEntity<List<Song>> getSongsByGroup(@RequestBody @NonNull String group) {
        return ResponseEntity.ok(songService.findSongsByGroup(group));
    }

    @GetMapping("/getByAlbum")
    public ResponseEntity<List<Song>> getSongsByAlbum(@RequestBody @NonNull String album) {
        return ResponseEntity.ok(songService.findSongsByAlbum(album));
    }

    @GetMapping("/delete")
    public ResponseEntity.BodyBuilder deleteSong(@RequestBody @NonNull Long id) {
        songService.delete(id);
        return ResponseEntity.ok();
    }

}
