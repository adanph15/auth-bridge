package com.adan.authbridge.registration.register.domain;

public class User {
    private final String email;
    private final String passwordHash;

    public User(String email, String passwordHash) {
        this.email = email;
        this.passwordHash = passwordHash;
    }

    public static User create(String email, String passwordHash) {
        return new User(email, passwordHash);
    }

    public String getEmail() {
        return email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }
}
