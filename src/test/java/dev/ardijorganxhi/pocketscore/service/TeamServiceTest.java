package dev.ardijorganxhi.pocketscore.service;

import dev.ardijorganxhi.pocketscore.client.SportMonksClient;
import dev.ardijorganxhi.pocketscore.model.response.BaseResponse;
import dev.ardijorganxhi.pocketscore.model.response.ListBaseResponse;
import dev.ardijorganxhi.pocketscore.model.sportmonks.team.Squads;
import dev.ardijorganxhi.pocketscore.model.sportmonks.team.Team;
import dev.ardijorganxhi.pocketscore.model.sportmonks.team.TeamSeasons;
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
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class TeamServiceTest {

    @InjectMocks
    private TeamService teamService;

    @Mock
    private SportMonksClient sportMonksClient;

    @Test
    public void it_should_get_all_teams() {
        Team team = Team.builder()
                .id(1)
                .name("team")
                .build();
        Team team1 = Team.builder()
                .id(2)
                .name("team2")
                .build();

        List<Team> teams = List.of(team, team1);

        ListBaseResponse<Team> teamListBaseResponse = ListBaseResponse.<Team>builder()
                .list(teams)
                .build();

        when(sportMonksClient.getAllTeams()).thenReturn(teamListBaseResponse);

        ListBaseResponse<Team> response = teamService.getAllTeams();

        assertEquals(response, teamListBaseResponse);
        verify(sportMonksClient).getAllTeams();
    }

    @Test
    public void it_should_get_team_by_id() {
        Integer teamId = 1;

        Team team = Team.builder()
                .id(teamId)
                .name("team")
                .build();

        BaseResponse<Team> teamBaseResponse = BaseResponse.<Team>builder()
                .response(team)
                .build();

        when(sportMonksClient.getTeamById(Long.valueOf(teamId))).thenReturn(teamBaseResponse);

        BaseResponse<Team> response = teamService.getTeamById(Long.valueOf(teamId));

        assertEquals(response, teamBaseResponse);
        verify(sportMonksClient).getTeamById(Long.valueOf(teamId));
    }

    @Test
    public void it_should_get_squads_by_teamid() {
        Integer teamId = 1;

        Squads squads = Squads.builder()
                .id(1)
                .build();

        List<Squads> squadsList = Collections.singletonList(squads);

        ListBaseResponse<Squads> teamListBaseResponse = ListBaseResponse.<Squads>builder()
                .list(squadsList)
                .build();

        when(sportMonksClient.getSquadsOfTeamById(Long.valueOf(teamId))).thenReturn(teamListBaseResponse);

        ListBaseResponse<Squads> response = teamService.getSquadsOfTeamById(Long.valueOf(teamId));

        assertEquals(response, teamListBaseResponse);
        verify(sportMonksClient).getSquadsOfTeamById(Long.valueOf(teamId));
    }

    @Test
    public void it_should_get_seasons_of_team_by_teamid() {
        Integer teamId = 1;

        TeamSeasons teamSeasons = TeamSeasons.builder()
                .id(1)
                .name("season1")
                .build();
        TeamSeasons teamSeasons1 = TeamSeasons.builder()
                .id(2)
                .name("season2")
                .build();

        Optional<List<TeamSeasons>> teamSeasonsList = Optional.of(List.of(teamSeasons, teamSeasons1));

        Team team = Team.builder()
                .id(teamId)
                .seasons(teamSeasonsList)
                .build();

        BaseResponse<Team> teamBaseResponse = BaseResponse.<Team>builder()
                .response(team)
                .build();

        when(sportMonksClient.getSeasonsOfTeamById(Long.valueOf(teamId))).thenReturn(teamBaseResponse);

        Optional<List<TeamSeasons>> response = Optional.ofNullable(teamService.getSeasonsOfTeamById(Long.valueOf(teamId)));

        assertEquals(response, teamBaseResponse.getResponse().getSeasons());
        verify(sportMonksClient).getSeasonsOfTeamById(Long.valueOf(teamId));

    }

    @Test
    public void it_should_get_rivals_of_team() {
        Integer teamId = 1;

        Team team = Team.builder()
                .id(1)
                .name("rival1")
                .build();
        Team team1 = Team.builder()
                .name("rival2")
                .build();

        Optional<List<Team>> rivals = Optional.ofNullable(List.of(team, team1));

        Team mainTeam = Team.builder()
                .rivals(rivals)
                .build();

        BaseResponse<Team> teamBaseResponse = BaseResponse.<Team>builder()
                .response(mainTeam)
                .build();

        when(sportMonksClient.getRivalsOfTeamById(Long.valueOf(teamId))).thenReturn(teamBaseResponse);

        Optional<List<Team>> response = Optional.ofNullable(teamService.getRivalsOfTeamById(Long.valueOf(teamId)));

        assertEquals(response, teamBaseResponse.getResponse().getRivals());
        verify(sportMonksClient).getRivalsOfTeamById(Long.valueOf(teamId));
    }
}
