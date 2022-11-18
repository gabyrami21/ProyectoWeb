package com.example.User.service;

import com.example.User.dao.UserRepository;
import com.example.User.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repo;

    public List<User> listAll(){
        return repo.findAll();
    }
    public User save(User user){
        return repo.save(user);
    }
    public User get(String username){
        return repo.findById(username).get();
    }
    public List<User> filterByName(String name){
        return repo.findUserByName(name);
    }
}
