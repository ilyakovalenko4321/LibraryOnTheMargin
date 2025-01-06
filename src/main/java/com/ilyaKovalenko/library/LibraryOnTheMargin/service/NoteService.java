package com.ilyaKovalenko.library.LibraryOnTheMargin.service;

import com.ilyaKovalenko.library.LibraryOnTheMargin.domain.note.Note;

import java.util.List;
import java.util.UUID;

public interface NoteService {

    List<Note> getWiredNotesChapter(UUID id, Long start, Long end, UUID uuid);

    Note createNewNote(Note note, UUID id);

    List<Note> getWiredNotesUser(UUID id);

}
