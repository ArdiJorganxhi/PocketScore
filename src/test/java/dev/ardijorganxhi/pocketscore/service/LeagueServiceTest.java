package dev.ardijorganxhi.pocketscore.service;

import dev.ardijorganxhi.pocketscore.client.SportMonksClient;
import dev.ardijorganxhi.pocketscore.model.sportmonks.response.*;
import dev.ardijorganxhi.pocketscore.model.sportmonks.scores.Fixture;
import dev.ardijorganxhi.pocketscore.model.sportmonks.scores.Score;
import dev.ardijorganxhi.pocketscore.model.sportmonks.scores.ScoreInfo;
import dev.ardijorganxhi.pocketscore.model.sportmonks.standings.Standings;
import dev.ardijorganxhi.pocketscore.model.sportmonks.team.Team;
import dev.ardijorganxhi.pocketscore.model.sportmonks.transfers.Transfer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class LeagueServiceTest {

    @InjectMocks
    private LeagueService leagueService;

    @Mock
    private SportMonksClient sportMonksClient;

    @Test
    public void it_should_get_scores() {
        ScoreInfo scoreInfo = ScoreInfo.builder()
                .goals(0)
                .participant("home")
                .build();

        ScoreInfo scoreInfo1 = ScoreInfo.builder()
                .goals(1)
                .participant("away")
                .build();


        Score score = Score.builder()
                .id(1)
                .score(scoreInfo)
                .build();

        Score score1 = Score.builder()
                .id(2)
                .score(scoreInfo1)
                .build();

        List<Score> scores = List.of(score, score1);

        Fixture fixture = Fixture.builder()
                .id(1)
                .name("fixture")
                .scoreList(scores)
                .build();

        List<Fixture> fixtures = Collections.singletonList(fixture);
        ListBaseResponse<Fixture> scoreResponse = ListBaseResponse.<Fixture>builder()
                .list(fixtures)
                .build();

        when(sportMonksClient.getScores()).thenReturn(scoreResponse);

        ListBaseResponse<Fixture> response = leagueService.getScores();

        assertEquals(scoreResponse, response);
        verify(sportMonksClient).getScores();

    }

    @Test
    public void it_should_get_team() {
        String teamName = "team";

        Team team = Team.builder()
                .id(1)
                .name(teamName)
                .build();

        List<Team> teams = Collections.singletonList(team);

        ListBaseResponse<Team> teamResponse = ListBaseResponse.<Team>builder()
                .list(teams)
                .build();

        when(sportMonksClient.getTeam(teamName)).thenReturn(teamResponse);

        ListBaseResponse<Team> response = leagueService.getTeam(teamName);

        assertEquals(teamResponse, response);
        verify(sportMonksClient).getTeam(teamName);

    }

    @Test
    public void it_should_get_standings() {
        Long leagueId = 1L;

        Standings standings = Standings.builder()
                .id(1)
                .leagueId(Math.toIntExact(leagueId))
                .build();

        List<Standings> standingList = Collections.singletonList(standings);

        ListBaseResponse<Standings> standingsResponse = ListBaseResponse.<Standings>builder()
                .list(standingList)
                .build();

        when(sportMonksClient.getStandings(leagueId)).thenReturn(standingsResponse);

        ListBaseResponse<Standings> response = leagueService.getStandings(leagueId);

        assertEquals(standingsResponse, response);
        verify(sportMonksClient).getStandings(leagueId);
    }

}
