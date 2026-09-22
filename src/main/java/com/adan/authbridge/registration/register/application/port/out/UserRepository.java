package com.adan.authbridge.registration.register.application.port.out;

import com.adan.authbridge.registration.register.domain.User;

public interface UserRepository {

    void save(User user);
    boolean existsByEmail(String email);
}