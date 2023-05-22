package dev.ardijorganxhi.pocketscore.repository;

import dev.ardijorganxhi.pocketscore.entity.User;
import dev.ardijorganxhi.pocketscore.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class UserRepositoryTest {

    @Mock
    private UserRepository userRepository;

    @Test
    public void it_should_find_user_by_email() {
        String email = "user@gmail.com";

        User user = User.builder()
                .email(email)
                .build();

        when(userRepository.findByEmail(email)).thenReturn(Optional.of(user));
    }
}
