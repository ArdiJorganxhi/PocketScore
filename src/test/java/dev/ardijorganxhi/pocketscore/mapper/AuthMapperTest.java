package dev.ardijorganxhi.pocketscore.mapper;

import dev.ardijorganxhi.pocketscore.config.PasswordEncoder;
import dev.ardijorganxhi.pocketscore.entity.User;
import dev.ardijorganxhi.pocketscore.model.request.RegisterRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class AuthMapperTest {

    @InjectMocks
    private AuthMapper authMapper;

    @Mock
    private PasswordEncoder passwordEncoder;


    @Test
    public void it_should_register() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        when(passwordEncoder.bCryptPasswordEncoder()).thenReturn(bCryptPasswordEncoder);


        RegisterRequest request = RegisterRequest.builder()
                .pocketName("user")
                .email("user@gmail.com")
                .password(bCryptPasswordEncoder.encode("user123"))
                .build();

        User user = User.builder()
                .id(1L)
                .pocketName("user")
                .email("user@gmail.com")
                .password(bCryptPasswordEncoder.encode("user123"))
                .build();

        User result = authMapper.register(request);

        assertEquals(user.getPocketName(), result.getPocketName());
        assertEquals(user.getEmail(), result.getEmail());

    }
}
