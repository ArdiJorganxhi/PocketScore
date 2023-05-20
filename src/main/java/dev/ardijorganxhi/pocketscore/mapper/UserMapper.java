package dev.ardijorganxhi.pocketscore.mapper;

import dev.ardijorganxhi.pocketscore.entity.FavoriteTeam;
import dev.ardijorganxhi.pocketscore.entity.User;
import dev.ardijorganxhi.pocketscore.model.dto.UserDto;
import dev.ardijorganxhi.pocketscore.model.sportmonks.team.Team;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {


    public UserDto toDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .pocketName(user.getPocketName())
                .build();
    }

    public FavoriteTeam addFavoriteTeam(Team team, Long userId) {
        return FavoriteTeam.builder()
                .id(team.getId())
                .teamName(team.getName())
                .userId(userId)
                .build();
    }
}
