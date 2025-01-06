package com.ilyaKovalenko.library.LibraryOnTheMargin.web.mapper;

import com.ilyaKovalenko.library.LibraryOnTheMargin.domain.chapter.Chapter;
import com.ilyaKovalenko.library.LibraryOnTheMargin.web.dto.Chapter.ChapterRequest;
import com.ilyaKovalenko.library.LibraryOnTheMargin.web.dto.Chapter.ChapterResponse;
import org.springframework.stereotype.Component;

@Component
public class ChapterMapper {

    // Преобразование Chapter в ChapterResponse
    public ChapterResponse toDto(Chapter chapter) {
        if (chapter == null) {
            return null;
        }

        ChapterResponse chapterResponse = new ChapterResponse();
        chapterResponse.setId(chapter.getId());
        chapterResponse.setInnerText(chapter.getInnerText());
        chapterResponse.setEndAt(chapter.getEndAt());
        chapterResponse.setNotes(chapter.getNotes());

        return chapterResponse;
    }

    // Преобразование ChapterRequest в Chapter
    public Chapter toEntity(ChapterRequest chapterRequest) {
        if (chapterRequest == null) {
            return null;
        }

        Chapter chapter = new Chapter();
        chapter.setId(chapterRequest.getId());
        chapter.setEndAt(chapterRequest.getEndAt());

        return chapter;
    }
}