package com.ilyaKovalenko.library.LibraryOnTheMargin.web.controller;

import com.ilyaKovalenko.library.LibraryOnTheMargin.domain.chapter.Chapter;
import com.ilyaKovalenko.library.LibraryOnTheMargin.domain.note.Note;
import com.ilyaKovalenko.library.LibraryOnTheMargin.service.ChapterService;
import com.ilyaKovalenko.library.LibraryOnTheMargin.service.Impl.ChapterServiceImpl;
import com.ilyaKovalenko.library.LibraryOnTheMargin.service.NoteService;
import com.ilyaKovalenko.library.LibraryOnTheMargin.web.dto.Chapter.ChapterRequest;
import com.ilyaKovalenko.library.LibraryOnTheMargin.web.dto.Chapter.ChapterResponse;
import com.ilyaKovalenko.library.LibraryOnTheMargin.web.dto.Note.NoteDto;
import com.ilyaKovalenko.library.LibraryOnTheMargin.web.mapper.ChapterMapper;
import com.ilyaKovalenko.library.LibraryOnTheMargin.web.mapper.NoteMapper;
import com.ilyaKovalenko.library.LibraryOnTheMargin.web.security.Context.SecurityUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/chapters")
@RequiredArgsConstructor
public class ChapterController {

    private final ChapterService chapterService;
    private final ChapterMapper mapper;

    @GetMapping("/nextPageWithNotes")
    public ChapterResponse getNextPage(@RequestBody ChapterRequest chapterRequest){
        Chapter chapter = mapper.toEntity(chapterRequest);
        UUID userId = SecurityUtil.getCurrentUserId();
        return mapper.toDto(chapterService.getNextPage(chapter, userId));
    }

}
