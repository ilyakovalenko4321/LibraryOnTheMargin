package com.ilyaKovalenko.library.LibraryOnTheMargin.repository;

import com.ilyaKovalenko.library.LibraryOnTheMargin.domain.chapter.Chapter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface ChapterRepository extends JpaRepository<Chapter, UUID> {

    @Query(value = """
                SELECT b.id,
                       SUBSTRING(b.inner_text FROM CAST(:previousEnd AS INTEGER) + 1 FOR CAST(:currentEnd AS INTEGER) - CAST(:previousEnd AS INTEGER)) AS inner_text,
                       b.created_at
                FROM books b
                WHERE b.id = :id
            """, nativeQuery = true)
    Optional<Chapter> findNextPage(@Param("id") UUID id, @Param("previousEnd") Long previousEnd, @Param("currentEnd") Long currentEnd);

}

