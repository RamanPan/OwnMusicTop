package ru.ramanpan.topmusicgroupsweb.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;


@Data
@RequiredArgsConstructor
public class TopDTO {
    private Long id;

    private LocalDate dateCreated;

    private String header;

    private String description;

    private String type;

    private String author;

    private String avatar;

    private Integer likes;

    private Integer dislikes;

    private Integer countLooks;
}

