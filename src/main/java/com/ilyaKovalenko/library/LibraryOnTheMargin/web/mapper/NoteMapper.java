package com.ilyaKovalenko.library.LibraryOnTheMargin.web.mapper;

import com.ilyaKovalenko.library.LibraryOnTheMargin.domain.note.Note;
import com.ilyaKovalenko.library.LibraryOnTheMargin.web.dto.NoteDto;
import org.springframework.stereotype.Component;

@Component
public class NoteMapper {

    // Преобразование из NoteDto в Note
    public Note toNote(NoteDto noteDto) {
        Note note = new Note();
        note.setBookId(noteDto.getBookId());  // Устанавливаем bookId
        note.setNoteHeader(noteDto.getNoteHeader());
        note.setNoteText(noteDto.getNoteText());
        note.setStartOffset(noteDto.getStartOffset().intValue());  // Преобразуем Long в int
        note.setEndOffset(noteDto.getEndOffset().intValue());  // Преобразуем Long в int
        note.setCreatedAt(java.time.LocalDateTime.now());  // Устанавливаем время создания
        return note;
    }

    // Преобразование из Note в NoteDto
    public NoteDto toNoteDto(Note note) {
        NoteDto noteDto = new NoteDto();
        noteDto.setBookId(note.getBookId());
        noteDto.setNoteHeader(note.getNoteHeader());
        noteDto.setNoteText(note.getNoteText());
        noteDto.setStartOffset((long) note.getStartOffset());  // Преобразуем int в Long
        noteDto.setEndOffset((long) note.getEndOffset());  // Преобразуем int в Long
        return noteDto;
    }
}
