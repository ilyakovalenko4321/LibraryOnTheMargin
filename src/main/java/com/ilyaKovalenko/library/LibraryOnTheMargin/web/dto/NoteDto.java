package com.ilyaKovalenko.library.LibraryOnTheMargin.web.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class NoteDto {

    private UUID bookId;
    private String noteHeader;
    private String noteText;
    private Long startOffset;
    private Long endOffset;

}
