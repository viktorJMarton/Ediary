package com.epam.ediary.service;

import com.epam.ediary.domain.Credentials;
import com.epam.ediary.domain.User;

public interface UserService {
    public User authenticate(Credentials credentials) throws AuthenticationException;
}
