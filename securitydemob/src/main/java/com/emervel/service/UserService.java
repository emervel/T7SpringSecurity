package com.emervel.service;

import com.emervel.domain.User;

/**
 * Created by guopm on 04/06/2017.
 */
public interface UserService {
    public User findByEmail(String email);
}
