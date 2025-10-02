package com.variphx.authserver.services;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.variphx.authserver.entities.User;
import com.variphx.authserver.repositories.UserRepository;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Iterator<User> userIterator = this.repository.findAll().iterator();
        while (userIterator.hasNext()) {
            System.out.println(userIterator.next().toString());
        }

        User user = repository.findById((long) 1).orElseThrow(() -> new UsernameNotFoundException(username));
        return user;
    }

}
