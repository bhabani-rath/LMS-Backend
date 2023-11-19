package com.example.library.RequestedBookcontroller;

import com.example.library.RequestedBookService.RequestedBookservice;
import com.example.library.RequestedBooks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class RequestedBooksController {

    @Autowired
    private RequestedBookservice repo;



    @PostMapping("/api/saveRequests")
    public ResponseEntity<RequestedBooks> saveRequestedBooks(@RequestBody RequestedBooks requestedBooks){
        return new ResponseEntity<RequestedBooks>(repo.saveRequests(requestedBooks), HttpStatus.CREATED);
    }

    @GetMapping("/api/viewAllRequestedBooks")
    public List<RequestedBooks> sendAllBookreq(){
        return repo.findAllRequests();
    }
    @PostMapping("/api/deleteBookRequest/{id}")
    public ResponseEntity<RequestedBooks> deleteRequestedBooks(@PathVariable("id") Long id){
        return new ResponseEntity<RequestedBooks>(repo.deleteRequests(id),HttpStatus.GONE);
    }
}
