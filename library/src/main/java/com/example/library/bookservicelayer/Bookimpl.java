package com.example.library.bookservicelayer;

import com.example.library.BookRepository;
import com.example.library.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Bookimpl implements Bookservice{
    @Autowired
    private BookRepository bookrepo;
    @Override
    public Books saveBooks(Books newBooks) {
        return bookrepo.save(newBooks);
    }

    @Override
    public List<Books> getAllBooks() {
        return bookrepo.findAll();
    }
}
