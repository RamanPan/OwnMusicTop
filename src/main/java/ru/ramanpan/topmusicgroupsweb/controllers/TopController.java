package ru.ramanpan.topmusicgroupsweb.controllers;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
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
    private TopService topService;

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
    @GetMapping("/getAllByUser")
    public ResponseEntity<List<Top>> getAllTopsByUser(@RequestBody @NonNull Long id) {
        return ResponseEntity.ok(topService.findTopsByUser(id));
    }
}
