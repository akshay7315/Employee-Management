package com.main.userdetailservice;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.main.dao.Userrepo;
import com.main.entity.User_1;

@Service
public class Userdetailservice implements UserDetailsService {

    @Autowired
    private Userrepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User_1> userOpt = userRepo.findByUsername(username);

        if (userOpt.isPresent()) {
            User_1 user = userOpt.get();
            return org.springframework.security.core.userdetails.User.builder()
                    .username(user.getUsername())
                    .password(user.getPassword())
                    .roles(user.getRole()) 
                    .build();
        } else {
            throw new UsernameNotFoundException("Username not found: " + username);
        }
    }
}
