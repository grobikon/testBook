package com.test.book.repo

import com.test.book.domain.Book
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface BookRepo: JpaRepository<Book, Long> {

    @Query(value = "SELECT * FROM book ORDER BY book_title DESC",
        nativeQuery = true)
    fun getBooksSortTitleDesc(): List<Book>

    @Query(value = "SELECT * FROM book ORDER BY book_author",
        nativeQuery = true)
    fun getBooksSortAuthor(): List<Book>
}