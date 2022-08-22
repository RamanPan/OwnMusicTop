package ru.ramanpan.topmusicgroupsweb.controllers;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ramanpan.topmusicgroupsweb.dto.MusicianDTO;
import ru.ramanpan.topmusicgroupsweb.model.Musician;
import ru.ramanpan.topmusicgroupsweb.services.MusicianService;
import ru.ramanpan.topmusicgroupsweb.services.TopService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/musicians")
public class MusicianController {
    private final MusicianService musicianService;

    @PostMapping("/add")
    public ResponseEntity.BodyBuilder addMusician(@RequestBody @NonNull MusicianDTO musicianDTO) {
        musicianService.save(musicianDTO);
        return ResponseEntity.ok();
    }
    @PostMapping("/update")
    public ResponseEntity.BodyBuilder updateMusician(@RequestBody @NonNull MusicianDTO musicianDTO) {
        musicianService.update(musicianDTO);
        return ResponseEntity.ok();
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<Musician>> getAllMusicians() {
        return ResponseEntity.ok(musicianService.findAllMusician());
    }
    @GetMapping("/getByTop")
    public ResponseEntity<List<Musician>> getMusiciansByTop(@RequestBody @NonNull Long topId) {
        return ResponseEntity.ok(musicianService.findAllMusicianByTop(topId));
    }
    @GetMapping("/delete")
    public ResponseEntity.BodyBuilder deleteMusician(@RequestBody @NonNull Long id) {
        musicianService.delete(id);
        return ResponseEntity.ok();
    }

}
