package com.test.book.service

import com.test.book.domain.Book
import com.test.book.repo.BookRepo
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class ServiceBookImpl(
    private val bookRepo: BookRepo
): ServiceBook {
    private val logger = LoggerFactory.getLogger(ServiceBookImpl::class.java)

    override fun getBooksSortTitle(): List<Book> {
        return bookRepo.getBooksSortTitleDesc()
    }

    override fun getAuthorSortTitle(): List<Book> {
        return bookRepo.getBooksSortAuthor()
    }

    override fun saveBook(book: Book): Book {
        logger.info("Сохраняем новую книгу ${book.title} в БД")
        return bookRepo.save(book)
    }
}