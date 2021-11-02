package com.test.book.domain

import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.*

@Entity(name = Book.TABLE)
data class Book(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "${PREFIX}id", nullable = false, updatable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    var id: Long? = null,
    @Column(name = "${PREFIX}title", nullable = false, length= 150)
    var title: String,
    @Column(name = "${PREFIX}author", nullable = false, length= 150)
    var author: String,
    @Column(name = "${PREFIX}description", length= 150)
    var description: String
) {
    constructor() : this(
        id = null,
        title = "",
        author = "",
        description = ""
    )

    companion object {
        const val TABLE = "book"
        const val PREFIX = "book_"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Book

        if (id != other.id) return false
        if (title != other.title) return false
        if (author != other.author) return false
        if (description != other.description) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id?.hashCode() ?: 0
        result = 31 * result + (title.hashCode())
        result = 31 * result + (author.hashCode())
        result = 31 * result + (description.hashCode())
        return result
    }

    override fun toString(): String {
        return "Book(id=$id, title=$title, author=$author, description=$description)"
    }

}