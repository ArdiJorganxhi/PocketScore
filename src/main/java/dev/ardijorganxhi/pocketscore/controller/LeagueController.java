package dev.ardijorganxhi.pocketscore.controller;

import dev.ardijorganxhi.pocketscore.client.SportMonksClient;
import dev.ardijorganxhi.pocketscore.model.sportmonks.response.ScoreResponse;
import dev.ardijorganxhi.pocketscore.model.sportmonks.response.TeamResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/football")
@RequiredArgsConstructor
public class LeagueController {

    private final SportMonksClient sportMonksClient;
    @GetMapping("/scores")
    public ResponseEntity<ScoreResponse> getScores() {
        return ResponseEntity.ok(sportMonksClient.getScores());
    }

    @GetMapping("/teams/{team}")
    public ResponseEntity<TeamResponse> getTeam(@PathVariable String team) {
        return ResponseEntity.ok(sportMonksClient.getTeam(team));
    }
}