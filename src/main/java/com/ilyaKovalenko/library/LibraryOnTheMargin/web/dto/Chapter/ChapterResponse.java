package com.ilyaKovalenko.library.LibraryOnTheMargin.web.dto.Chapter;


import com.ilyaKovalenko.library.LibraryOnTheMargin.domain.note.Note;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class ChapterResponse {
    private UUID id;

    private String innerText;

    private Long endAt;

    private List<Note> notes;
}
