package com.adan.authbridge.registration.register.application.service;

import com.adan.authbridge.registration.register.application.model.RegisterUserCommand;
import com.adan.authbridge.registration.register.application.port.in.RegisterUserUseCase;
import com.adan.authbridge.registration.register.application.port.out.PasswordHasher;
import com.adan.authbridge.registration.register.application.port.out.UserRepository;
import com.adan.authbridge.registration.register.domain.User;
import org.springframework.stereotype.Service;

@Service
public class RegisterUserService implements RegisterUserUseCase {

    private final PasswordHasher passwordHasher;
    private final UserRepository userRepository;

    public RegisterUserService(
            PasswordHasher passwordHasher,
            UserRepository userRepository
    ) {
        this.passwordHasher = passwordHasher;
        this.userRepository = userRepository;
    }

    @Override
    public void register(RegisterUserCommand command) {

        if (userRepository.existsByEmail(command.email())) {
            throw new IllegalArgumentException("Email already registered");
        }

        String passwordHash = passwordHasher.hash(command.password());

        User user = User.create(
                command.email(),
                passwordHash
        );

        userRepository.save(user);
    }
}
