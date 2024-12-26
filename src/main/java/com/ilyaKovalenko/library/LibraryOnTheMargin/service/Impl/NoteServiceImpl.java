package com.ilyaKovalenko.library.LibraryOnTheMargin.service.Impl;

import com.ilyaKovalenko.library.LibraryOnTheMargin.domain.note.Note;
import com.ilyaKovalenko.library.LibraryOnTheMargin.repository.NoteRepository;
import com.ilyaKovalenko.library.LibraryOnTheMargin.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;

    @Override
    public List<Note> getWiredNotes(Long start, Long end) {
        return noteRepository.findWiredNotes(start, end);
    }

    @Override
    public Note createNewNote(Note note) {
        note.setCreatedAt(LocalDateTime.now());
        noteRepository.save(note);
        return note;
    }


}
