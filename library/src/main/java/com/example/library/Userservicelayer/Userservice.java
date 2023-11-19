package com.example.library.Userservicelayer;

import com.example.library.Users;

import java.util.List;

public interface Userservice {
    Users saveUsers(Users user);

    List<Users> getAllUsers();

    Users getUserById(Long id);

    Users updateUser(Long id,Users user);

    Users deleteUser(Long id);

    Users getAuthenticate(String username,String password);
}
