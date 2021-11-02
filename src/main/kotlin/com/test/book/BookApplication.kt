package com.test.book

import com.test.book.domain.Book
import com.test.book.service.ServiceBook
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class BookApplication{

	@Bean
	fun run(bookService: ServiceBook): CommandLineRunner {
		return CommandLineRunner {
			for (i in 1..100) {
				bookService.saveBook(Book(
					null,
					"Title $i",
					"Author $i",
					"Description $i"))
			}

			bookService.saveBook(Book(
				null,
				"А",
				"Author А",
				"Description А"))

			bookService.saveBook(Book(
				null,
				"Б",
				"Author Б",
				"Description Б"))

			bookService.saveBook(Book(
				null,
				"В",
				"Author В",
				"Description В"))

			bookService.saveBook(Book(
				null,
				"Г",
				"Author Г",
				"Description Г"))

			bookService.saveBook(Book(
				null,
				"Д",
				"Author Д",
				"Description Д"))
		}
	}
}

fun main(args: Array<String>) {
	runApplication<BookApplication>(*args)
}
