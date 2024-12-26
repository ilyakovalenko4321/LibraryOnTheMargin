package com.ilyaKovalenko.library.LibraryOnTheMargin.service;

import com.ilyaKovalenko.library.LibraryOnTheMargin.domain.note.Note;

import java.util.List;

public interface NoteService {

    List<Note> getWiredNotes(Long start, Long end);

    Note createNewNote(Note note);

}
