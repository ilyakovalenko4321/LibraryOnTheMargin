package com.ilyaKovalenko.library.LibraryOnTheMargin.domain.note;

import com.ilyaKovalenko.library.LibraryOnTheMargin.domain.chapter.Chapter;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "notes")
public class Note {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(name = "book_id", nullable = false)
    private UUID bookId; // Поле изменено на "book" для согласованности

    @Column(name = "note_header", nullable = false)
    private String noteHeader;

    //@Lob
    @Column(name = "note_text", nullable = false)
    private String noteText;

    @Column(name = "start_offset", nullable = false)
    private int startOffset;

    @Column(name = "end_offset", nullable = false)
    private int endOffset;

    @Column(name = "created_at", nullable = false, updatable = false)
    private java.time.LocalDateTime createdAt;
}
