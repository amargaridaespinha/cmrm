package org.example.cm.virtual_library

abstract class Book(
    var title: String,
    var author: String,
    var publicationYear: Int,
    var availableCopies: Int
) {

    init {
        println("Book '$title' by $author created.")
    }

    fun getPublicationEra(): String {
        return when {
            publicationYear < 1980 -> "Classic"
            publicationYear <= 2010 -> "Modern"
            else -> "Contemporary"
        }
    }

    fun updateAvailableCopies(value: Int) {
        if (value < 0) {
            println("Can't have negative copies!")
        } else {
            availableCopies = value
            if (value == 0) {
                println("Warning: Book is now out of stock!")
            }
        }
    }

    abstract fun getStorageInfo(): String
}