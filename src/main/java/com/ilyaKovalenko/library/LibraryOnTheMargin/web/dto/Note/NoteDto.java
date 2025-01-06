package com.ilyaKovalenko.library.LibraryOnTheMargin.web.dto.Note;

import lombok.Data;

import java.util.UUID;

@Data
public class NoteDto {

    private UUID userId;
    private UUID bookId;
    private String noteHeader;
    private String noteText;
    private Long startOffset;
    private Long endOffset;

}
