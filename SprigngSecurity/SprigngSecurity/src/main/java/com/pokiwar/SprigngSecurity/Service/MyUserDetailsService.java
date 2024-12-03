package com.pokiwar.SprigngSecurity.Service;

import com.pokiwar.SprigngSecurity.Repo.UserRepo;
import com.pokiwar.SprigngSecurity.model.UserPrincipal;
import com.pokiwar.SprigngSecurity.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users user = repo.findByUsername(username);

        if(user == null){
            System.out.println("User Not Found ");
            throw new UsernameNotFoundException("user not found ");
        }

        return new UserPrincipal(user);
    }
}
