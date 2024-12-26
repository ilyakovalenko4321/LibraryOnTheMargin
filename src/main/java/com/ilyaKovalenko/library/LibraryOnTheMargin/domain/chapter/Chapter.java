package com.ilyaKovalenko.library.LibraryOnTheMargin.domain.chapter;

import com.ilyaKovalenko.library.LibraryOnTheMargin.domain.note.Note;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "books")
public class Chapter {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(name = "inner_text", nullable = false)
    private String innerText;

    @Column(name = "created_at", nullable = false, updatable = false)
    private java.time.LocalDateTime createdAt;

    @Transient
    private Long endAt;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")  // Вместо mappedBy, мы указываем внешний ключ здесь
    private List<Note> notes;
}
