package com.example.library.RequestedBookService;

import com.example.library.RequestedBookRepository;
import com.example.library.RequestedBooks;
import com.example.library.ResourceNotFoundException;
import com.example.library.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestedBookimpl implements RequestedBookservice{

    @Autowired
    private RequestedBookRepository reqbookrepo;
    @Override
    public RequestedBooks saveRequests(RequestedBooks requestedBooks) {
        return reqbookrepo.save(requestedBooks);
    }

    @Override
    public List<RequestedBooks> findAllRequests() {
        return reqbookrepo.findAll();
    }

    @Override
    public RequestedBooks deleteRequests(Long id) {
        RequestedBooks reqBook=reqbookrepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Users","ID",id));
        reqbookrepo.deleteById(id);
        return null;
    }


}
