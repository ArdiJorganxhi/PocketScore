package dev.ardijorganxhi.pocketscore.service;

import dev.ardijorganxhi.pocketscore.entity.User;
import dev.ardijorganxhi.pocketscore.mapper.UserMapper;
import dev.ardijorganxhi.pocketscore.model.dto.UserDto;
import dev.ardijorganxhi.pocketscore.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserMapper userMapper;


    @Test
    public void it_should_find_by_id() {
        Long userId = 1L;

        User user = User.builder()
                .id(userId)
                .pocketName("user")
                .email("user@gmail.com")
                .build();

        UserDto userDto = UserDto.builder()
                .id(userId)
                .pocketName("user")
                .build();

        when(userMapper.toDto(user)).thenReturn(userDto);
        when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        UserDto result = userService.getById(userId);

        assertEquals(userDto.getId(), result.getId());
        assertEquals(userDto.getPocketName(), result.getPocketName());

        verify(userRepository).findById(userId);
        verify(userMapper).toDto(user);
    }

    @Test
    public void it_should_delete_by_id() {
        Long userId = 1L;

        User user = User.builder()
                .id(userId)
                .pocketName("user")
                .isDeleted(false)
                .build();

        when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        userService.deleteUserById(userId);

        assertTrue(user.isDeleted());

        verify(userRepository).findById(userId);
        verify(userRepository).save(user);
    }
}
