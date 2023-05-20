package dev.ardijorganxhi.pocketscore.controller;

import dev.ardijorganxhi.pocketscore.client.SportMonksClient;
import dev.ardijorganxhi.pocketscore.model.sportmonks.response.ScoreResponse;
import dev.ardijorganxhi.pocketscore.model.sportmonks.response.StandingsResponse;
import dev.ardijorganxhi.pocketscore.model.sportmonks.response.TeamResponse;
import dev.ardijorganxhi.pocketscore.service.SportMonksService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/leagues")
@RequiredArgsConstructor
public class LeagueController {

    private final SportMonksService sportMonksService;
    @GetMapping("/scores")
    public ResponseEntity<ScoreResponse> getScores() {
        return ResponseEntity.ok(sportMonksService.getScores());
    }

    @GetMapping("/teams/{team}")
    public ResponseEntity<TeamResponse> getTeam(@PathVariable String team) {
        return ResponseEntity.ok(sportMonksService.getTeam(team));
    }

    @GetMapping("/standings/{leagueId}")
    public ResponseEntity<StandingsResponse> getLeagueStandings(@PathVariable Long leagueId) {
        return ResponseEntity.ok(sportMonksService.getStandings(leagueId));
    }
}
