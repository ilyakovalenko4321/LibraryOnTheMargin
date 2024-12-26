package com.ilyaKovalenko.library.LibraryOnTheMargin.service.Impl;

import com.ilyaKovalenko.library.LibraryOnTheMargin.domain.chapter.Chapter;
import com.ilyaKovalenko.library.LibraryOnTheMargin.domain.exceptions.EndOfBookException;
import com.ilyaKovalenko.library.LibraryOnTheMargin.repository.ChapterRepository;
import com.ilyaKovalenko.library.LibraryOnTheMargin.service.ChapterService;
import com.ilyaKovalenko.library.LibraryOnTheMargin.service.NoteService;
import com.ilyaKovalenko.library.LibraryOnTheMargin.service.Props.ChapterProps;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ChapterServiceImpl implements ChapterService {

    private final ChapterRepository chapterRepository;
    private final NoteService noteService;


    private final ChapterProps props;

    @Override
    public Chapter getNextPage(Chapter chapter) {
        Chapter nextChapter = chapterRepository.findNextPage(chapter.getId(), chapter.getEndAt(), chapter.getEndAt() + props.getTextLength())
                .orElseThrow(() -> new NoSuchElementException("Book is not found"));
        nextChapter.setEndAt(chapter.getEndAt() + props.getTextLength());
        nextChapter.setInnerText(makeSofter(nextChapter.getInnerText()));
        nextChapter.setNotes(noteService.getWiredNotes(chapter.getId(), chapter.getEndAt(), chapter.getEndAt() + props.getTextLength()));
        return nextChapter;
    }

    private String makeSofter(String innerText) {
        String substring = innerText.substring(props.getTextLength().intValue() - props.getSoftLength().intValue(), props.getTextLength().intValue());

        int breakIndex = -1;

        if (substring.contains("\r")) {
            breakIndex = substring.indexOf("\r");
        } else if (substring.contains("\n")) {
            breakIndex = substring.indexOf("\n");
        } else if (substring.contains("\t")) {
            breakIndex = substring.indexOf("\t");
        } else if (substring.matches(".*\\s{4,}.*")) {
            breakIndex = substring.indexOf("    "); // Обрезка по красной строке (4 пробела)
        }

        if (breakIndex != -1) {
            return innerText.substring(0, props.getTextLength().intValue() - props.getSoftLength().intValue() + breakIndex);
        }

        return innerText;
    }


}
