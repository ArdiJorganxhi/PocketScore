package dev.ardijorganxhi.pocketscore.service;

import antlr.Token;
import dev.ardijorganxhi.pocketscore.entity.User;
import dev.ardijorganxhi.pocketscore.mapper.AuthMapper;
import dev.ardijorganxhi.pocketscore.model.request.LoginRequest;
import dev.ardijorganxhi.pocketscore.model.request.RegisterRequest;
import dev.ardijorganxhi.pocketscore.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final AuthMapper authMapper;
    private final TokenService tokenService;
    private final AuthenticationManager authenticationManager;
    private final UserService userService;

    public void register(RegisterRequest request) {
        final User user = authMapper.register(request);
        userRepository.save(user);
    }

    public String login(LoginRequest request) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        } catch (BadCredentialsException e) {
            throw new Exception(e.getMessage());
        }

        User user = userRepository.findByEmail(request.getEmail()).orElseThrow();
        return tokenService.generateToken(user);
    }
}
