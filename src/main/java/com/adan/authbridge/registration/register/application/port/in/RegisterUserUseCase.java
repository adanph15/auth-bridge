package com.adan.authbridge.registration.register.application.port.in;

import com.adan.authbridge.registration.register.application.model.RegisterUserCommand;

public interface RegisterUserUseCase {
    void register(RegisterUserCommand command);

}
