package com.example.library.bookcontrollerlayer;

import com.example.library.Books;
import com.example.library.RequestedBookService.RequestedBookservice;
import com.example.library.RequestedBooks;
import com.example.library.bookservicelayer.Bookservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
public class BookController {
    @Autowired
    private Bookservice bookService;
    @Autowired
    private RequestedBookservice repo;
    @PostMapping("/api/saveBooks")
    public ResponseEntity<Books> saveNewBooks(
            @RequestParam("file") MultipartFile file,
            @RequestParam("bookname") String bookname,
            @RequestParam("totalbookquantity") Long totalBookQuantity,
            @RequestParam("author") String author,
            @RequestParam("type") String type,
            @RequestParam("availablebookquantity") Long availableBookQuantity) {

        Books newBooks = new Books();
        newBooks.setBookname(bookname);
        newBooks.setTotalbookquantity(totalBookQuantity);
        newBooks.setAuthor(author);
        newBooks.setType(type);
        newBooks.setAvailablebookquantity(availableBookQuantity);

        try {
            // Set image data
            newBooks.setBookimage(file.getBytes());
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(bookService.saveBooks(newBooks), HttpStatus.CREATED);
    }
    @GetMapping("/api/getAllBooks")
    public List<Books> sendAllBooks(){
        return bookService.getAllBooks();
    }


}
