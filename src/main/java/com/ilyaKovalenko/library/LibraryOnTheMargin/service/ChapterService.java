package com.ilyaKovalenko.library.LibraryOnTheMargin.service;

import com.ilyaKovalenko.library.LibraryOnTheMargin.domain.chapter.Chapter;

import java.util.UUID;

public interface ChapterService {

    Chapter getNextPage(Chapter chapter, UUID uuid);

}
