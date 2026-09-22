package com.adan.authbridge.registration.register.application.port.out;

public interface PasswordHasher {
    String hash(String rawPassword);
}
