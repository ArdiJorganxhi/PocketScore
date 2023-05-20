package dev.ardijorganxhi.pocketscore.mapper;

import dev.ardijorganxhi.pocketscore.config.PasswordEncoder;
import dev.ardijorganxhi.pocketscore.entity.User;
import dev.ardijorganxhi.pocketscore.model.request.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthMapper {
    private final PasswordEncoder passwordEncoder;
    public User register(RegisterRequest request) {
        return User.builder()
                .pocketName(request.getPocketName())
                .email(request.getEmail())
                .password(passwordEncoder.bCryptPasswordEncoder().encode(request.getPassword()))
                .build();
    }
}
