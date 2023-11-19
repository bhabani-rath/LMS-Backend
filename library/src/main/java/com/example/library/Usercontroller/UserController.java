package com.example.library.Usercontroller;

import com.example.library.Users;
import com.example.library.Userservicelayer.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    private Userservice userservice;
    @PostMapping("/api/saveStudents")
    public ResponseEntity<Users> sendUsersDetails(@RequestBody Users user){
        return new ResponseEntity<Users>(userservice.saveUsers(user), HttpStatus.CREATED);
    }
    @GetMapping("/api/viewAllUsers")
        public List<Users> getAllUser(){
        return  userservice.getAllUsers();
    }
    @GetMapping("/api/finduserbyid/{id}")
    public ResponseEntity<Users> getUser(@PathVariable("id") Long id){
        return new ResponseEntity<Users>(userservice.getUserById(id),HttpStatus.FOUND);
    }
    @PutMapping("/api/updateUsers/{id}")
    public ResponseEntity<Users> updateUsers(@PathVariable("id") Long id,@RequestBody Users user){
        return new ResponseEntity<Users>(userservice.updateUser(id,user),HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/api/deleteUser/{id}")
    public ResponseEntity<Users> deleteUsers(@PathVariable("id") Long id){
        return new ResponseEntity<Users>(userservice.deleteUser(id),HttpStatus.GONE);
    }
    @GetMapping("/api/getUser/{username}/{password}")
    public ResponseEntity<Users> findUsername(@PathVariable("username") String username,@PathVariable("password") String password){
        return new ResponseEntity<Users>(userservice.getAuthenticate(username,password),HttpStatus.FOUND);
    }
}
