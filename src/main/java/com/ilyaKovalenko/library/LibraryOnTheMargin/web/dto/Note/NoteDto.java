package com.ilyaKovalenko.library.LibraryOnTheMargin.web.dto.Note;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;

@Data
public class NoteDto {

    @NotNull
    private UUID bookId;
    @NotNull
    private String noteHeader;
    private String noteText;
    @NotNull
    private Long startOffset;
    @NotNull
    private Long endOffset;

}
