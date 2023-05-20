package dev.ardijorganxhi.pocketscore.service;

import dev.ardijorganxhi.pocketscore.client.SportMonksClient;
import dev.ardijorganxhi.pocketscore.model.sportmonks.response.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public ListTransferResponse getTransfers() {
        return sportMonksClient.getAllTransfers();
    }

    public TransferResponse getTransferById(Long transferId) {
        return sportMonksClient.getTransferById(transferId);
    }

    public ListTransferResponse getTransferByTeam(String team) {
        return sportMonksClient.getTransferByTeams(team);
    }
}
