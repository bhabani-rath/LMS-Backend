package com.example.library.IssuedBooksServiceLayer;

import com.example.library.IssuedBooks;
import com.example.library.IssuedbooksRepository;
import com.example.library.RequestedBooks;
import com.example.library.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IssuedBooksimpl implements IssuedBooksservice{
    @Autowired
    private IssuedbooksRepository repo;


    @Override
    public IssuedBooks saveIssuedBooks(IssuedBooks issuedBooks) {
        return repo.save(issuedBooks);
    }

    @Override
    public List<IssuedBooks> getAllIssuedBooks() {
        return repo.findAll();
    }

    @Override
    public IssuedBooks deleteBooks(Long id) {
        IssuedBooks issuedBooks=repo.findById(id).orElseThrow(()->new ResourceNotFoundException("Users","ID",id));
        repo.deleteById(id);
        return null;
    }

    @Override
    public List<IssuedBooks> findIssuedBooks(Long userid) {
        return repo.findByUserId(userid);
    }


}
