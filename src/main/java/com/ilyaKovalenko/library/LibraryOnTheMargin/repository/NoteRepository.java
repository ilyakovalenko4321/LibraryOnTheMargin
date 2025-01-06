package com.ilyaKovalenko.library.LibraryOnTheMargin.repository;

import com.ilyaKovalenko.library.LibraryOnTheMargin.domain.note.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface NoteRepository extends JpaRepository<Note, UUID> {

    @Query(value = """
            SELECT n.*
            FROM notes n
                WHERE n.book_id = :bookId
                AND ((n.start_offset BETWEEN :start AND :stop)
                OR (n.end_offset BETWEEN :start AND :stop)
                OR (n.start_offset <= :start AND n.end_offset >= :stop))
            """, nativeQuery = true)
    List<Note> findWiredNotes(@Param("bookId") UUID bookId, @Param("start") Long start, @Param("stop") Long stop);

    @Modifying
    @Query(value = """
        INSERT INTO users_notes (user_id, note_id) VALUES (:userId, :noteId)
        """, nativeQuery = true)
    void wiredNoteWithUser(@Param("userId") UUID userId, @Param("noteId") UUID noteId);

    @Query(value= """
            SELECT * FROM users_notes u_n
            JOIN notes n ON n.id = u_n.user_id
            WHERE u_n.id = :userId""", nativeQuery = true)
    List<Note> findWiredNotesUser(@Param("userId") UUID id);

}
