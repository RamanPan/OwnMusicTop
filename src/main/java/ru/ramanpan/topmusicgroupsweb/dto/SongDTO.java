package ru.ramanpan.topmusicgroupsweb.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@RequiredArgsConstructor
public class SongDTO {
    private Long id;

    private LocalDate dateCreated;

    private String name;

    private String author;

    private String album;

    private Integer place;

    private Long idTop;
}
