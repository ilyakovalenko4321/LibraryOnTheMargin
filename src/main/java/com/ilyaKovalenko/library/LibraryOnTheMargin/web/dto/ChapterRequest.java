package com.ilyaKovalenko.library.LibraryOnTheMargin.web.dto;

import com.ilyaKovalenko.library.LibraryOnTheMargin.domain.note.Note;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class ChapterRequest {
    private UUID id;

    private Long endAt;
}
