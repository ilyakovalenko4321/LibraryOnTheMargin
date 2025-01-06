package com.ilyaKovalenko.library.LibraryOnTheMargin.web.controller;


import com.ilyaKovalenko.library.LibraryOnTheMargin.domain.note.Note;
import com.ilyaKovalenko.library.LibraryOnTheMargin.repository.UserRepository;
import com.ilyaKovalenko.library.LibraryOnTheMargin.service.NoteService;
import com.ilyaKovalenko.library.LibraryOnTheMargin.web.dto.Note.NoteDto;
import com.ilyaKovalenko.library.LibraryOnTheMargin.web.mapper.NoteMapper;
import com.ilyaKovalenko.library.LibraryOnTheMargin.web.security.Context.SecurityUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/notes")
@RequiredArgsConstructor
public class NoteController {

    private final NoteService noteService;
    private final NoteMapper mapper;

    @PostMapping("/newNote")
    public Note createNewNote(@RequestBody @Validated NoteDto dto){
        Note note = mapper.toNote(dto);
        UUID userId = SecurityUtil.getCurrentUserId();
        return noteService.createNewNote(note, userId);
    }

    @GetMapping("/allNotes")
    public List<Note> getAllUserNotes(){
        UUID userId = SecurityUtil.getCurrentUserId();
        return noteService.getWiredNotesUser(userId);
    }

    //ToDo: сделать возможность переходить по note
}
