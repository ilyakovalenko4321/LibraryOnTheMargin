package com.ilyaKovalenko.library.LibraryOnTheMargin.web.controller;

import com.ilyaKovalenko.library.LibraryOnTheMargin.domain.chapter.Chapter;
import com.ilyaKovalenko.library.LibraryOnTheMargin.service.Impl.ChapterServiceImpl;
import com.ilyaKovalenko.library.LibraryOnTheMargin.web.dto.ChapterRequest;
import com.ilyaKovalenko.library.LibraryOnTheMargin.web.dto.ChapterResponse;
import com.ilyaKovalenko.library.LibraryOnTheMargin.web.mapper.ChapterMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/chapters")
@RequiredArgsConstructor
public class ChapterController {

    private final ChapterServiceImpl chapterService;
    private final ChapterMapper mapper;

    @GetMapping("/nextPage")
    public ChapterResponse getNextPage(@RequestBody ChapterRequest chapterRequest){
        Chapter chapter = mapper.toEntity(chapterRequest);
        return mapper.toDto(chapterService.getNextPage(chapter));
    }

}
