package com.example.library.bookservicelayer;

import com.example.library.Books;

import java.util.List;

public interface Bookservice {
    Books saveBooks(Books newBooks);

    List<Books> getAllBooks();
}
