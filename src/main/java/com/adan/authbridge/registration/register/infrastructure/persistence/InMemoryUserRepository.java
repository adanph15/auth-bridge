package com.adan.authbridge.registration.register.infrastructure.persistence;

import com.adan.authbridge.registration.register.application.port.out.UserRepository;
import com.adan.authbridge.registration.register.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryUserRepository implements UserRepository {

    @Override
    public void save(User user) {
        System.out.println("User saved: " + user.getEmail());
    }

    @Override
    public boolean existsByEmail(String email) {
        return false;
    }
}