package com.hunghv1998.authorbooks.security;

import com.hunghv1998.authorbooks.entity.Role;
import com.hunghv1998.authorbooks.entity.User;
import com.hunghv1998.authorbooks.repository.RoleRepository;
import com.hunghv1998.authorbooks.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired private RoleRepository roleRepository;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email).
                orElseThrow(() -> new UsernameNotFoundException("email not found"));
    }

    @Override
    public void saveUser(User user) {
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setActive(1);
        Role userRole = roleRepository.findByRole("USER")
                .orElseThrow(() -> new NoSuchElementException("wrong role"));
        user.setRoles(new HashSet<>(List.of(userRole)));
        userRepository.save(user);
    }
}
