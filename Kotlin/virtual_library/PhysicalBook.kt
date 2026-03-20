package org.example.cm.virtual_library

class PhysicalBook(
    title: String,
    author: String,
    publicationYear: Int,
    availableCopies: Int,
    var weight: Int,
    var hasHardcover: Boolean = true
) : Book(title, author, publicationYear, availableCopies) {

    override fun getStorageInfo(): String {
        return if (hasHardcover) {
            "Physical book: ${weight}g, Hardcover: Yes"
        } else {
            "Physical book: ${weight}g, Hardcover: No"
        }
    }
}