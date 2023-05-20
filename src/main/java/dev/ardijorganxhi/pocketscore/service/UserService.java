package dev.ardijorganxhi.pocketscore.service;

import dev.ardijorganxhi.pocketscore.entity.User;
import dev.ardijorganxhi.pocketscore.mapper.UserMapper;
import dev.ardijorganxhi.pocketscore.model.dto.UserDto;
import dev.ardijorganxhi.pocketscore.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public User getByEmailAndPassword(String email) {
        return userRepository.findByEmail(email).orElseThrow();
    }

    public UserDto getById(Long id) {
        final User user = userRepository.findById(id).orElseThrow();
        return userMapper.toDto(user);
    }

    public void deleteUserById(Long id) {
        final User user = userRepository.findById(id).orElseThrow();
        user.setDeleted(true);
        userRepository.save(user);
    }
}
