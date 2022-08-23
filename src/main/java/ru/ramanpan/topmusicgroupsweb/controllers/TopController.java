package ru.ramanpan.topmusicgroupsweb.controllers;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ramanpan.topmusicgroupsweb.dto.TopDTO;
import ru.ramanpan.topmusicgroupsweb.model.Top;
import ru.ramanpan.topmusicgroupsweb.services.TopService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/top")
public class TopController {
    private final TopService topService;

    @PostMapping("/create")
    public ResponseEntity.BodyBuilder createTop(@RequestBody @NonNull TopDTO topDTO) {
        topService.save(topDTO);
        return ResponseEntity.ok();
    }

    @PostMapping("/update")
    public ResponseEntity.BodyBuilder updateTop(@RequestBody @NonNull TopDTO topDTO) {
        topService.update(topDTO);
        return ResponseEntity.ok();
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Top>> getAllTops() {
        return ResponseEntity.ok(topService.findAll());
    }

    @GetMapping("/getAllByUser/{id}")
    public ResponseEntity<List<Top>> getAllTopsByUser(@PathVariable("id") Long id) {
        return ResponseEntity.ok(topService.findTopsByUser(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity.BodyBuilder deleteTop(@PathVariable("id") Long id) {
        topService.delete(id);
        return ResponseEntity.ok();
    }

    @GetMapping("/addLike/{id}")
    public ResponseEntity.BodyBuilder addLike(@PathVariable("id") Long idTop) {
        topService.addLike(idTop);
        return ResponseEntity.ok();
    }

    @GetMapping("/removeLike/{id}")
    public ResponseEntity.BodyBuilder removeLike(@PathVariable("id") Long idTop) {
        topService.removeLike(idTop);
        return ResponseEntity.ok();
    }

    @GetMapping("/addDislike/{id}")
    public ResponseEntity.BodyBuilder addDislike(@PathVariable("id") Long idTop) {
        topService.addDislike(idTop);
        return ResponseEntity.ok();
    }

    @GetMapping("/removeDislike/{id}")
    public ResponseEntity.BodyBuilder removeDislike(@PathVariable("id") Long idTop) {
        topService.removeDislike(idTop);
        return ResponseEntity.ok();
    }
}
