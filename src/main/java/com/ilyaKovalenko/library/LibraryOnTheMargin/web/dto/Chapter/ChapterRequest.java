package com.ilyaKovalenko.library.LibraryOnTheMargin.web.dto.Chapter;

import lombok.Data;

import java.util.UUID;

@Data
public class ChapterRequest {
    private UUID id;

    private Long endAt;
}
