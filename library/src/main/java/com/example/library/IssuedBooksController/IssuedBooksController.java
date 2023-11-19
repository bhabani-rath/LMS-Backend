package com.example.library.IssuedBooksController;

import com.example.library.IssuedBooks;
import com.example.library.IssuedBooksServiceLayer.IssuedBooksservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class IssuedBooksController {
    @Autowired
    private IssuedBooksservice issuedBooksservice;
    @PostMapping("/api/saveIssuedBooks")
    public ResponseEntity<IssuedBooks> saveIssuedBook(@RequestBody IssuedBooks issuedBooks){
        return new ResponseEntity<IssuedBooks>(issuedBooksservice.saveIssuedBooks(issuedBooks), HttpStatus.CREATED);
    }
    @GetMapping("/api/getIssuedBooks")
    public List<IssuedBooks> sendAllIssuedBooks(){
        return issuedBooksservice.getAllIssuedBooks();
    }
    @PostMapping("/api/deleteIssuedBooks/{id}")
    public ResponseEntity<IssuedBooks> deleteBooks(@PathVariable("id") Long id){
        return new ResponseEntity<IssuedBooks>(issuedBooksservice.deleteBooks(id),HttpStatus.GONE);
    }
    @GetMapping("/api/findIssuedBooksByUserId/{id}")
   public List<IssuedBooks> getAllIssuedBookByUserId(@PathVariable("id") Long userid){
        return issuedBooksservice.findIssuedBooks(userid);
   }
}
