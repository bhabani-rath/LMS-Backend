package com.example.library.RequestedBookService;

import com.example.library.RequestedBooks;

import java.util.List;

public interface RequestedBookservice {
    RequestedBooks saveRequests(RequestedBooks requestedBooks);

   List<RequestedBooks> findAllRequests();

   RequestedBooks deleteRequests(Long id);
}
