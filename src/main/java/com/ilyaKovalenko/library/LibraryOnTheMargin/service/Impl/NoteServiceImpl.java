package com.ilyaKovalenko.library.LibraryOnTheMargin.service.Impl;

import com.ilyaKovalenko.library.LibraryOnTheMargin.domain.note.Note;
import com.ilyaKovalenko.library.LibraryOnTheMargin.repository.NoteRepository;
import com.ilyaKovalenko.library.LibraryOnTheMargin.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Note> getWiredNotesChapter(UUID id, Long start, Long end) {
        return noteRepository.findWiredNotes(id, start, end);
    }

    @Override
    @Transactional
    public Note createNewNote(Note note) {
        note.setCreatedAt(LocalDateTime.now());
        noteRepository.save(note);
        return note;
    }

    @Override
    public List<Note> getWiredNotesUser(UUID id) {
        return noteRepository.findWiredNotesUser(id);
    }


}
