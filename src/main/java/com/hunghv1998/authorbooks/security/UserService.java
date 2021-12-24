package com.hunghv1998.authorbooks.security;

import com.hunghv1998.authorbooks.entity.User;

public interface UserService {

    public User findUserByEmail(String email);
    public void saveUser(User user);
}
