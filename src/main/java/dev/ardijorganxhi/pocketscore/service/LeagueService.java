package dev.ardijorganxhi.pocketscore.service;

import dev.ardijorganxhi.pocketscore.client.SportMonksClient;
import dev.ardijorganxhi.pocketscore.model.sportmonks.response.ListBaseResponse;
import dev.ardijorganxhi.pocketscore.model.sportmonks.scores.Fixture;
import dev.ardijorganxhi.pocketscore.model.sportmonks.standings.Standings;
import dev.ardijorganxhi.pocketscore.model.sportmonks.team.Team;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LeagueService {

    private final SportMonksClient sportMonksClient;

    public ListBaseResponse<Fixture> getScores() {
        return sportMonksClient.getScores();
    }

    public ListBaseResponse<Team> getTeam(String team) {
        return sportMonksClient.getTeam(team);
    }

    public ListBaseResponse<Standings> getStandings(Long leagueId) {
        return sportMonksClient.getStandings(leagueId);
    }
}
