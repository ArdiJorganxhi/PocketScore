package dev.ardijorganxhi.pocketscore.controller;


import dev.ardijorganxhi.pocketscore.model.response.BaseResponse;
import dev.ardijorganxhi.pocketscore.model.response.ListBaseResponse;
import dev.ardijorganxhi.pocketscore.model.sportmonks.team.Squads;
import dev.ardijorganxhi.pocketscore.model.sportmonks.team.Team;
import dev.ardijorganxhi.pocketscore.model.sportmonks.team.TeamSeasons;
import dev.ardijorganxhi.pocketscore.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/teams")
@RequiredArgsConstructor
public class TeamController {

    private final TeamService teamService;

    @GetMapping
    public ResponseEntity<ListBaseResponse<Team>> getAllTeams() {
        return ResponseEntity.ok(teamService.getAllTeams());
    }
    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse<Team>> getTeamById(@PathVariable Long id) {
        return ResponseEntity.ok(teamService.getTeamById(id));
    }
    @GetMapping("/{id}/squads")
    public ResponseEntity<ListBaseResponse<Squads>> getSquadsOfTeam(@PathVariable Long id) {
        return ResponseEntity.ok(teamService.getSquadsOfTeamById(id));
    }
    @GetMapping("/{id}/seasons")
    public ResponseEntity<List<TeamSeasons>> getSeasonsOfTeam(@PathVariable Long id) {
        return ResponseEntity.ok(teamService.getSeasonsOfTeamById(id));
    }
    @GetMapping("/{id}/rivals")
    public ResponseEntity<List<Team>> getRivalsOfTeam(@PathVariable Long id) {
        return ResponseEntity.ok(teamService.getRivalsOfTeamById(id));
    }


}
