package dev.ardijorganxhi.pocketscore.mapper;

import dev.ardijorganxhi.pocketscore.entity.User;
import dev.ardijorganxhi.pocketscore.model.dto.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {


    public UserDto toDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .pocketName(user.getPocketName())
                .build();
    }
}
