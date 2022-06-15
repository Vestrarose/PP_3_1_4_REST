package com.vestra.pp3bootstrap.service;

import com.vestra.pp3bootstrap.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        UserDetails user = userRepository.findByName(name);
        if (user == null) {
            throw new UsernameNotFoundException(name);
        }
        return user;
    }
}
