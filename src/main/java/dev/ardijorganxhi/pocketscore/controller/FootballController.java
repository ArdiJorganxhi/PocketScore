package dev.ardijorganxhi.pocketscore.controller;

import dev.ardijorganxhi.pocketscore.client.SportMonksClient;
import dev.ardijorganxhi.pocketscore.model.sportmonks.response.Fixture;
import dev.ardijorganxhi.pocketscore.model.sportmonks.response.ScoreResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/football")
@RequiredArgsConstructor
public class FootballController {

    private final SportMonksClient sportMonksClient;
    @GetMapping("/scores")
    public ResponseEntity<ScoreResponse> getScores() {
        return ResponseEntity.ok(sportMonksClient.getScores());
    }
}
