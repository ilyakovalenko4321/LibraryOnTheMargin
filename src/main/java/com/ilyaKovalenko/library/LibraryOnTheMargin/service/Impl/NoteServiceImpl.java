package com.ilyaKovalenko.library.LibraryOnTheMargin.service.Impl;

import com.ilyaKovalenko.library.LibraryOnTheMargin.domain.note.Note;
import com.ilyaKovalenko.library.LibraryOnTheMargin.repository.NoteRepository;
import com.ilyaKovalenko.library.LibraryOnTheMargin.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;

    @Override
    public List<Note> getWiredNotes(UUID id, Long start, Long end) {
        return noteRepository.findWiredNotes(id, start, end);
    }

    @Override
    public Note createNewNote(Note note) {
        note.setCreatedAt(LocalDateTime.now());
        noteRepository.save(note);
        return note;
    }


}
