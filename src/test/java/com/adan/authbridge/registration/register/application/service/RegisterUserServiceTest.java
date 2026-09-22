package com.adan.authbridge.registration.register.application.service;

import com.adan.authbridge.registration.register.application.model.RegisterUserCommand;
import com.adan.authbridge.registration.register.application.port.out.PasswordHasher;
import com.adan.authbridge.registration.register.application.port.out.UserRepository;
import com.adan.authbridge.registration.register.domain.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class RegisterUserServiceTest {

    @Test
    void shouldRegisterUser() {

        PasswordHasher passwordHasher = rawPassword -> "hashed-password";

        final User[] savedUser = new User[1];

        UserRepository userRepository = user -> savedUser[0] = user;

        RegisterUserService service = new RegisterUserService(
                passwordHasher,
                userRepository
        );

        RegisterUserCommand command = new RegisterUserCommand(
                "user@example.com",
                "Secret123!"
        );

        service.register(command);

        assertNotNull(savedUser[0]);
        assertEquals("user@example.com", savedUser[0].getEmail());
        assertEquals("hashed-password", savedUser[0].getPasswordHash());
    }
}