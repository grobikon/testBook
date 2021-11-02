package com.test.book.service

import com.test.book.domain.Book

interface ServiceBook {
    fun getBooksSortTitle(): List<Book>
    fun getAuthorSortTitle(): List<Book>
    fun saveBook(book: Book): Book
}