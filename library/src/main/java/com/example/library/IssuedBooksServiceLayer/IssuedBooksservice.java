package com.example.library.IssuedBooksServiceLayer;

import com.example.library.IssuedBooks;

import java.util.List;

public interface IssuedBooksservice {
    IssuedBooks saveIssuedBooks(IssuedBooks issuedBooks);

    List<IssuedBooks> getAllIssuedBooks();

    IssuedBooks deleteBooks(Long id);

    List<IssuedBooks> findIssuedBooks(Long userid);
}
