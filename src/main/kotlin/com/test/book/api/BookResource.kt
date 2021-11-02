package com.test.book.api

import com.test.book.domain.Book
import com.test.book.service.ServiceBook
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.net.URI

@RestController
@RequestMapping(path = ["/","/api"])
class BookResource(
    val bookService: ServiceBook,
){

    /**
     * Отправляем список книг отсортированных по Заголовку отправляем список книг отсортированных по Автору
     */
    @GetMapping("/booksSortTitle")
    fun getBooksSortTitle(): ResponseEntity<List<Book>> {
        //ok - 200 ответ пользователю, что все прошло хорошо
        //body - в теле возвращаем всех пользователей
        return ResponseEntity.ok().body(bookService.getBooksSortTitle())
    }

    /**
     * Отправляем список книг отсортированных по Автору
     */
    @GetMapping("/booksSortAuthor")
    fun getAuthorSortTitle(): ResponseEntity<List<Book>> {
        //ok - 200 ответ пользователю, что все прошло хорошо
        //body - в теле возвращаем всех пользователей
        return ResponseEntity.ok().body(bookService.getAuthorSortTitle())
    }


    /**
     * Сохраняем книгу
     */
    @PostMapping("/book/save")
    fun saveUser(@RequestBody book: Book): ResponseEntity<Book>{
        //body - в теле возвращаем сохраненного пользователя
        //created() - 201 создан, что-то было создано на сервере
        val uri: URI = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/book/save").toUriString())
        return ResponseEntity.created(uri).body(bookService.saveBook(book))
    }
}
