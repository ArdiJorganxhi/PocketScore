package dev.ardijorganxhi.pocketscore.controller;

import dev.ardijorganxhi.pocketscore.model.sportmonks.response.ListBaseResponse;
import dev.ardijorganxhi.pocketscore.model.sportmonks.scores.Fixture;
import dev.ardijorganxhi.pocketscore.model.sportmonks.standings.Standings;
import dev.ardijorganxhi.pocketscore.model.sportmonks.team.Team;
import dev.ardijorganxhi.pocketscore.service.LeagueService;
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

    private final LeagueService leagueService;
    @GetMapping("/scores")
    public ResponseEntity<ListBaseResponse<Fixture>> getScores() {
        return ResponseEntity.ok(leagueService.getScores());
    }

    @GetMapping("/teams/{team}")
    public ResponseEntity<ListBaseResponse<Team>> getTeam(@PathVariable String team) {
        return ResponseEntity.ok(leagueService.getTeam(team));
    }

    @GetMapping("/standings/{leagueId}")
    public ResponseEntity<ListBaseResponse<Standings>> getLeagueStandings(@PathVariable Long leagueId) {
        return ResponseEntity.ok(leagueService.getStandings(leagueId));
    }
}
