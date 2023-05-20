package dev.ardijorganxhi.pocketscore.controller;

import dev.ardijorganxhi.pocketscore.client.SportMonksClient;
import dev.ardijorganxhi.pocketscore.model.sportmonks.response.StandingsResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/standings")
@RequiredArgsConstructor
public class StandingsController {

    private final SportMonksClient sportMonksClient;

    @GetMapping("/{leagueId}")
    public ResponseEntity<StandingsResponse> getLeagueStandings(@PathVariable Long leagueId) {
        return ResponseEntity.ok(sportMonksClient.getStandings(leagueId));
    }
}
