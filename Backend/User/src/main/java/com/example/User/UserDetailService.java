package com.example.User;

import com.example.User.domain.User;
import com.example.User.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository repo;

    /*
    Entradas: un username de tipo id
    Salidas:
    Función: Cargar eñ usuario por el nombre de usuario
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = (User) repo.findUserByName(username);
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPass(), new ArrayList<>());
    }
}
