package ru.ramanpan.topmusicgroupsweb.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
@RequiredArgsConstructor
public class MusicianDTO {
    private Long id;

    private String name;

    private String genre;

    private String avatar;

    private String bestSong;

    private String description;

    private Integer place;

    private Long idTop;
}
