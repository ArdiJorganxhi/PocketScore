package dev.ardijorganxhi.pocketscore.service;

import dev.ardijorganxhi.pocketscore.client.SportMonksClient;
import dev.ardijorganxhi.pocketscore.entity.FavoriteTeam;
import dev.ardijorganxhi.pocketscore.mapper.UserMapper;
import dev.ardijorganxhi.pocketscore.model.response.ListBaseResponse;
import dev.ardijorganxhi.pocketscore.model.sportmonks.scores.Fixture;
import dev.ardijorganxhi.pocketscore.model.sportmonks.team.Team;
import dev.ardijorganxhi.pocketscore.repository.FavoriteTeamRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class FavouriteTeamServiceTest {

    @InjectMocks
    private FavoriteTeamService favoriteTeamService;

    @Mock
    private FavoriteTeamRepository favoriteTeamRepository;

    @Mock
    private SportMonksClient sportMonksClient;

    @Mock
    private UserMapper userMapper;

    @Test
    public void it_should_save_favourite_team() {
        String teamName = "Galatasaray";
        Long userId = 1L;

        Team team = Team.builder()
                .name(teamName)
                .build();

        List<Team> teams = Collections.singletonList(team);

        ListBaseResponse<Team> teamResponse = ListBaseResponse.<Team>builder()
                .list(teams)
                .build();

        when(sportMonksClient.getTeam(teamName)).thenReturn(teamResponse);

        FavoriteTeam favoriteTeam = FavoriteTeam.builder()
                .teamName(teamName)
                .build();

        when(userMapper.addFavoriteTeam((any(Team.class)), eq(userId))).thenReturn(favoriteTeam);

        favoriteTeamService.addFavoriteTeam(teamName, userId);

        verify(sportMonksClient).getTeam(teamName);
        verify(userMapper).addFavoriteTeam(teamResponse.getList().get(0), userId);
        verify(favoriteTeamRepository).save(favoriteTeam);
    }

    @Test
    public void it_should_get_favourite_teaminfo_by_name() {
        Integer teamId = 1;
        Long userId = 1L;

        FavoriteTeam favoriteTeam = FavoriteTeam.builder()
                .id(teamId)
                .teamName("team")
                .userId(userId)
                .build();

        when(favoriteTeamRepository.findByIdAndUserId(teamId, userId)).thenReturn(Optional.of(favoriteTeam));

        Team team = Team.builder()
                .id(teamId)
                .name("team")
                .build();

        List<Team> teams = Collections.singletonList(team);

        ListBaseResponse<Team> teamResponse = ListBaseResponse.<Team>builder()
                .list(teams)
                .build();

        when(sportMonksClient.getTeam(favoriteTeam.getTeamName())).thenReturn(teamResponse);

        favoriteTeamService.getFavoriteTeamInfo(teamId, userId);

        verify(favoriteTeamRepository).findByIdAndUserId(teamId, userId);
        verify(sportMonksClient).getTeam(favoriteTeam.getTeamName());
    }

    @Test
    public void it_should_get_favourite_teams() {
        Long userId = 1L;

        FavoriteTeam favoriteTeam = FavoriteTeam.builder()
                .id(1)
                .teamName("team1")
                .build();

        FavoriteTeam favoriteTeam2 = FavoriteTeam.builder()
                .id(2)
                .teamName("team2")
                .build();

        List<FavoriteTeam> favoriteTeams = List.of(favoriteTeam, favoriteTeam2);

        String teams = "1,2";

        Fixture fixture = Fixture.builder()
                .id(1)
                .build();

        Fixture fixture2 = Fixture.builder()
                .id(2)
                .build();

        List<Fixture> fixtures = List.of(fixture, fixture2);

        ListBaseResponse<Fixture> scoreResponse = ListBaseResponse.<Fixture>builder()
                .list(fixtures)
                .build();

        when(favoriteTeamRepository.findByUserId(userId)).thenReturn(favoriteTeams);
        when(sportMonksClient.getFavTeamsFixture(teams)).thenReturn(scoreResponse);

        ListBaseResponse<Fixture> response = favoriteTeamService.getFavoriteTeams(userId);

        verify(favoriteTeamRepository).findByUserId(userId);
        verify(sportMonksClient).getFavTeamsFixture(teams);
        assertEquals(scoreResponse, response);


    }
}
