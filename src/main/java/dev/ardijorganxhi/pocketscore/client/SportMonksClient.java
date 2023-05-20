package dev.ardijorganxhi.pocketscore.client;


import dev.ardijorganxhi.pocketscore.model.sportmonks.response.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "sportmonksclient", url = "https://api.sportmonks.com/v3/football")
public interface SportMonksClient {
    @GetMapping("/fixtures?api_token=${token}&include=scores")
    ScoreResponse getScores();

    @GetMapping("/standings/live/leagues/{leagueId}?api_token=${token}")
    StandingsResponse getStandings(@PathVariable Long leagueId);

    @GetMapping("/teams/search/{team}?api_token=${token}&include=trophies;players;")
    TeamResponse getTeam(@PathVariable String team);

    @GetMapping("/fixtures/multi/{teams}?api_token=${token}")
    ScoreResponse getFavTeamsFixture(@PathVariable String teams);

    @GetMapping("/transfers?api_token=${token}")
    ListTransferResponse getAllTransfers();

    @GetMapping("/transfers/{transferId}?api_token=${token}")
    TransferResponse getTransferById(@PathVariable Long transferId);

    @GetMapping("//transfers/teams/{team}?api_token=${token}")
    ListTransferResponse getTransferByTeams(@PathVariable String team);

}
