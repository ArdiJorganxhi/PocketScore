package dev.ardijorganxhi.pocketscore.controller;

import dev.ardijorganxhi.pocketscore.client.SportMonksClient;
import dev.ardijorganxhi.pocketscore.model.dto.UserDto;
import dev.ardijorganxhi.pocketscore.model.sportmonks.response.ScoreResponse;
import dev.ardijorganxhi.pocketscore.model.sportmonks.response.TeamResponse;
import dev.ardijorganxhi.pocketscore.service.FavoriteTeamService;
import dev.ardijorganxhi.pocketscore.service.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.MDC;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static dev.ardijorganxhi.pocketscore.utils.MdcConstant.X_USER_ID;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final FavoriteTeamService favoriteTeamService;
    private final SportMonksClient sportMonksClient;

    @GetMapping
    public ResponseEntity<UserDto> getById() {
        return ResponseEntity.ok(userService.getById(Long.valueOf(MDC.get(X_USER_ID))));
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable Long id) {
        userService.deleteUserById(id);
    }

    @PostMapping("/favourite-team/{team}")
    public void addFavouriteTeam(@PathVariable String team) {
        favoriteTeamService.addFavoriteTeam(team, Long.valueOf(MDC.get(X_USER_ID)));
    }

    @GetMapping("/favourite-team/{id}")
    public ResponseEntity<TeamResponse> getFavouriteTeamInfo(@PathVariable Integer id) {
        return ResponseEntity.ok(favoriteTeamService.getFavoriteTeamInfo(id, Long.valueOf(MDC.get(X_USER_ID))));
    }

    @GetMapping("/favourite-team/fixtures")
    public ResponseEntity<ScoreResponse> getFavTeamsFixtures() {
        return ResponseEntity.ok(favoriteTeamService.getFavoriteTeams(Long.valueOf(MDC.get(X_USER_ID))));
    }
}
