package ru.ramanpan.topmusicgroupsweb.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@RequiredArgsConstructor
public class AlbumDTO {
    private Long id;

    private LocalDate dateCreated;

    private String name;

    private String musicGroup;

    private String avatar;

    private Integer place;

    private Long idTop;
}
