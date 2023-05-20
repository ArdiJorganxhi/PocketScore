package dev.ardijorganxhi.pocketscore.service;

import dev.ardijorganxhi.pocketscore.client.SportMonksClient;
import dev.ardijorganxhi.pocketscore.model.sportmonks.response.ScoreResponse;
import dev.ardijorganxhi.pocketscore.model.sportmonks.response.StandingsResponse;
import dev.ardijorganxhi.pocketscore.model.sportmonks.response.TeamResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SportMonksService {

    private final SportMonksClient sportMonksClient;

    public ScoreResponse getScores() {
        return sportMonksClient.getScores();
    }

    public TeamResponse getTeam(String team) {
        return sportMonksClient.getTeam(team);
    }

    public StandingsResponse getStandings(Long leagueId) {
        return sportMonksClient.getStandings(leagueId);
    }
}
