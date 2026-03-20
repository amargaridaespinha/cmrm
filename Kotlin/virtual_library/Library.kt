package org.example.cm.virtual_library

class Library(var name: String) {

    private val books = mutableListOf<Book>()

    companion object {
        private var totalBooksCreated = 0

        fun incrementTotalBooks() {
            totalBooksCreated++
        }

        fun getTotalBooksCreated(): Int {
            return totalBooksCreated
        }
    }

    fun addBook(book: Book) {
        books.add(book)
        incrementTotalBooks()
        println("Book '${book.title}' by ${book.author} has been added to the library.")
    }

    fun borrowBook(title: String) {
        for (book in books) {
            if (book.title.equals(title, ignoreCase = true)) {
                if (book.availableCopies > 0) {
                    book.updateAvailableCopies(book.availableCopies - 1)
                    println("Successfully borrowed '${book.title}'. Copies remaining: ${book.availableCopies}")
                } else {
                    println("Sorry, no copies of '${book.title}' available.")
                }
                return
            }
        }
        println("Book '$title' not found in the library.")
    }

    fun returnBook(title: String) {
        for (book in books) {
            if (book.title.equals(title, ignoreCase = true)) {
                book.updateAvailableCopies(book.availableCopies + 1)
                println("Book '${book.title}' returned successfully. Copies available: ${book.availableCopies}")
                return
            }
        }
        println("Book '$title' not found in the library.")
    }

    fun showBooks() {
        if (books.isEmpty()) {
            println("Library is empty.")
            return
        }
        println("--- Library Catalog ---")
        for (book in books) {
            println("Title: ${book.title}, Author: ${book.author}, Era: ${book.getPublicationEra()}, Available: ${book.availableCopies} copies")
            println("Storage: ${book.getStorageInfo()}")
        }
    }

    fun searchByAuthor(author: String) {
        var found = false
        println("Books by $author:")
        for (book in books) {
            if (book.author.equals(author, ignoreCase = true)) {
                println("- ${book.title} (${book.getPublicationEra()}, ${book.availableCopies} copy/copies available)")
                found = true
            }
        }
        if (!found) {
            println("No books found by $author.")
        }
    }
}