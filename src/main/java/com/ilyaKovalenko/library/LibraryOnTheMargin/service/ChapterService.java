package com.ilyaKovalenko.library.LibraryOnTheMargin.service;

import com.ilyaKovalenko.library.LibraryOnTheMargin.domain.chapter.Chapter;

public interface ChapterService {

    Chapter getNextPage(Chapter chapter);

}
