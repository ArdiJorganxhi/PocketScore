package dev.ardijorganxhi.pocketscore.service;

import dev.ardijorganxhi.pocketscore.entity.User;
import dev.ardijorganxhi.pocketscore.mapper.AuthMapper;
import dev.ardijorganxhi.pocketscore.model.request.LoginRequest;
import dev.ardijorganxhi.pocketscore.model.request.RegisterRequest;
import dev.ardijorganxhi.pocketscore.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AuthServiceTest {

    @InjectMocks
    private AuthService authService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private AuthMapper authMapper;

    @Mock
    private AuthenticationManager authenticationManager;

    @Mock
    private TokenService tokenService;


    @Test
    public void it_should_register() {
        RegisterRequest request = RegisterRequest.builder()
                .pocketName("user")
                .email("user@gmail.com")
                .password("user123")
                .build();

        User user = User.builder()
                .pocketName("user")
                .email("user@gmail.com")
                .password("user123")
                .build();

        when(authMapper.register(request)).thenReturn(user);

        authService.register(request);

        verify(authMapper).register(request);
        verify(userRepository).save(user);
    }

    @Test
    public void it_should_login() throws Exception {
        LoginRequest request = LoginRequest.builder()
                .email("user@gmail.com")
                .password("user123")
                .build();

        User user = User.builder()
                .email("user@gmail.com")
                .password("user123")
                .build();

        when(userRepository.findByEmail(request.getEmail())).thenReturn(Optional.of(user));

        authService.login(request);

        verify(authenticationManager).authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        verify(userRepository).findByEmail(request.getEmail());
        verify(tokenService).generateToken(user);

    }
}
