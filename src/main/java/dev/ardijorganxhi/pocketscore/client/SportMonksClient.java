package dev.ardijorganxhi.pocketscore.client;


import dev.ardijorganxhi.pocketscore.model.sportmonks.response.ScoreResponse;
import dev.ardijorganxhi.pocketscore.model.sportmonks.response.StandingsResponse;
import dev.ardijorganxhi.pocketscore.model.sportmonks.response.TeamResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(value = "sportmonksclient", url = "https://api.sportmonks.com/v3/football")
public interface SportMonksClient {
    @GetMapping("/fixtures?api_token=${token}&include=scores")
    ScoreResponse getScores();

    @GetMapping("/standings/live/leagues/{leagueId}?api_token=${token}")
    StandingsResponse getStandings(@PathVariable Long leagueId);

    @GetMapping("/teams/search/{team}?api_token=${token}&include=trophies;players;")
    TeamResponse getTeam(@PathVariable String team);

    @GetMapping("/fixtures/multi/{teams}?api_token=${token}&include=")
    String getFavTeamsFixture(@PathVariable String teams);

}
