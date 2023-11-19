package com.example.library.Userservicelayer;

import com.example.library.ResourceNotFoundException;
import com.example.library.UserRepository;
import com.example.library.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserImpl implements Userservice{
    @Autowired
    private UserRepository userrepo;
    @Override
    public Users saveUsers(Users user) {
        return userrepo.save(user);
    }

    @Override
    public List<Users> getAllUsers() {
        return userrepo.findAll();
    }

    @Override
    public Users getUserById(Long id) {
        Optional<Users> userid=userrepo.findById(id);
        if(userid.isPresent()){
            return userid.get();
        }else{
            throw new ResourceNotFoundException("Users","ID",id);
        }

    }

    @Override
    public Users updateUser(Long id, Users user) {
       Users olduser=userrepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Users","ID",id));
       olduser.setName(user.getName());
       olduser.setUsername(user.getUsername());
       olduser.setPassword(user.getPassword());
       olduser.setEmail(user.getEmail());
       olduser.setPhone(user.getPhone());
       olduser.setAddress(user.getAddress());
       return olduser;
    }

    @Override
    public Users deleteUser(Long id) {
        Users user=userrepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Users","ID",id));
        userrepo.deleteById(id);
        return null;
    }

    @Override
    public Users getAuthenticate(String username, String password) {
        Optional<Users> user=userrepo.findByUsername(username);
   //     Optional<Users> email=userrepo.findByEmail(username);
        String userpass=user.get().getPassword();
//        String useremail=email.get().getEmail();
        if(Objects.equals(userpass,password)){
            if(user.isPresent()){
                return user.get();
            } else{
                throw new ResourceNotFoundException("Users","Username or Email",username);
            }
        }
        throw new ResourceNotFoundException("Users","Username or Email",username);
    }
}
