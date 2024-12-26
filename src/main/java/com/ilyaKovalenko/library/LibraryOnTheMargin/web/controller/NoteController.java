package com.ilyaKovalenko.library.LibraryOnTheMargin.web.controller;


import com.ilyaKovalenko.library.LibraryOnTheMargin.domain.note.Note;
import com.ilyaKovalenko.library.LibraryOnTheMargin.service.NoteService;
import com.ilyaKovalenko.library.LibraryOnTheMargin.web.dto.NoteDto;
import com.ilyaKovalenko.library.LibraryOnTheMargin.web.mapper.NoteMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
