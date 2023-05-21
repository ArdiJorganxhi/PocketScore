package dev.ardijorganxhi.pocketscore.mapper;

import dev.ardijorganxhi.pocketscore.entity.FavoriteTeam;
import dev.ardijorganxhi.pocketscore.entity.User;
import dev.ardijorganxhi.pocketscore.model.dto.UserDto;
import dev.ardijorganxhi.pocketscore.model.sportmonks.team.Team;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class UserMapperTest {

    @InjectMocks
    private UserMapper userMapper;

    @Test
    public void it_should_return_dto() {
        User user = User.builder()
                .id(1L)
                .pocketName("user")
                .email("user@gmail.com")
                .build();
        UserDto userDto = UserDto.builder()
                .id(1L)
                .pocketName("user")
                .build();

        UserDto result = userMapper.toDto(user);

        assertEquals(userDto.getId(), result.getId());
        assertEquals(userDto.getPocketName(), result.getPocketName());
    }

    @Test
    public void it_should_add_favourite_teams() {
        Long userId = 1L;

        Team team = Team.builder()
                .id(1)
                .name("team")
                .build();

        FavoriteTeam favoriteTeam = FavoriteTeam.builder()
                .id(team.getId())
                .teamName(team.getName())
                .userId(userId)
                .build();

        FavoriteTeam result = userMapper.addFavoriteTeam(team, userId);

        assertEquals(result.getId(), favoriteTeam.getId());
        assertEquals(result.getTeamName(), favoriteTeam.getTeamName());
        assertEquals(result.getUserId(), favoriteTeam.getUserId());


    }
}
