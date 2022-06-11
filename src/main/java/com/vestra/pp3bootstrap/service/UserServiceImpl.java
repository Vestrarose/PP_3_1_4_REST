package com.vestra.pp3bootstrap.service;
import com.vestra.pp3bootstrap.model.User;
import com.vestra.pp3bootstrap.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Transactional
@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public void addUser(User u) {
        u.setPassword(passwordEncoder.encode(u.getPassword()));
        userRepository.save(u);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findUserById(id);
    }

    @Override
    public void updateUser(User u) {
        String passwordFromForm = u.getPassword();
        String encodedPasswordFromBase = userRepository.findUserById(u.getId()).getPassword();
        if(passwordFromForm.length() == 0 || passwordFromForm.equals(encodedPasswordFromBase)) {
            u.setPassword(encodedPasswordFromBase);
        } else {
            if(passwordEncoder.matches(passwordFromForm, encodedPasswordFromBase)){
                u.setPassword(encodedPasswordFromBase);
            } else {
                u.setPassword(passwordEncoder.encode(passwordFromForm));
            }
        }
        userRepository.save(u);
    }

    @Override
    public User getByName(String name) {
        return userRepository.findUserByName(name);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails user = userRepository.findUserByName(username);
        if (user == null) {
            throw new UsernameNotFoundException("Could not find user with that name");
        }
        return user;
    }
}