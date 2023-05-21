package dev.ardijorganxhi.pocketscore.controller;

import dev.ardijorganxhi.pocketscore.model.sportmonks.players.Player;
import dev.ardijorganxhi.pocketscore.model.sportmonks.players.PlayerStats;
import dev.ardijorganxhi.pocketscore.model.sportmonks.players.PlayerTrophies;
import dev.ardijorganxhi.pocketscore.model.response.BaseResponse;
import dev.ardijorganxhi.pocketscore.model.response.ListBaseResponse;
import dev.ardijorganxhi.pocketscore.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/players")
@RequiredArgsConstructor
public class PlayerController {

    private final PlayerService playerService;

    @GetMapping
    public ResponseEntity<ListBaseResponse<Player>> getAllPlayers() {
        return ResponseEntity.ok(playerService.getAllPlayers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse<Player>> getPlayerById(@PathVariable Long id) {
        return ResponseEntity.ok(playerService.getPlayerById(id));
    }

    @GetMapping("/countries/{id}")
    public ResponseEntity<ListBaseResponse<Player>> getPlayersByCountryId(@PathVariable Long id) {
        return ResponseEntity.ok(playerService.getPlayersByCountryId(id));
    }

    @GetMapping("/search")
    public ResponseEntity<ListBaseResponse<Player>> getPlayerBySearch(@RequestParam(name = "player") String player) {
        return ResponseEntity.ok(playerService.getPlayerBySearch(player));
    }

    @GetMapping("/{id}/stats")
    public ResponseEntity<List<PlayerStats>> getStatsByPlayer(@PathVariable Long id) {
        return ResponseEntity.ok(playerService.getStatsByPlayer(id));
    }

    @GetMapping("/{id}/trophies")
    public ResponseEntity<List<PlayerTrophies>> getTrophiesByPlayer(@PathVariable Long id) {
        return ResponseEntity.ok(playerService.getTrophiesByPlayer(id));
    }

}
