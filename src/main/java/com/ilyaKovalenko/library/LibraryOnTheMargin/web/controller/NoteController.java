package com.ilyaKovalenko.library.LibraryOnTheMargin.web.controller;


import com.ilyaKovalenko.library.LibraryOnTheMargin.domain.note.Note;
import com.ilyaKovalenko.library.LibraryOnTheMargin.repository.UserRepository;
import com.ilyaKovalenko.library.LibraryOnTheMargin.service.NoteService;
import com.ilyaKovalenko.library.LibraryOnTheMargin.web.dto.Note.NoteDto;
import com.ilyaKovalenko.library.LibraryOnTheMargin.web.mapper.NoteMapper;
import lombok.RequiredArgsConstructor;
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
    public Note createNewNote(@RequestBody NoteDto dto){
        Note note = mapper.toNote(dto);
        return noteService.createNewNote(note);
    }


    //ToDo: Сделать проверку на то, твой ли это UUID
    @GetMapping("/allNotes")
    public List<Note> getAllNotes(@RequestBody UUID id){
        return noteService.getWiredNotesUser(id);
    }

    //ToDo: сделать возможность переходить по note
}
