package dev.ardijorganxhi.pocketscore.controller;

import dev.ardijorganxhi.pocketscore.client.SportMonksClient;
import dev.ardijorganxhi.pocketscore.model.dto.UserDto;
import dev.ardijorganxhi.pocketscore.model.response.ListBaseResponse;
import dev.ardijorganxhi.pocketscore.model.sportmonks.scores.Fixture;
import dev.ardijorganxhi.pocketscore.model.sportmonks.team.Team;
import dev.ardijorganxhi.pocketscore.service.FavoriteTeamService;
import dev.ardijorganxhi.pocketscore.service.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.MDC;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<ListBaseResponse<Team>> getFavouriteTeamInfo(@PathVariable Integer id) {
        return ResponseEntity.ok(favoriteTeamService.getFavoriteTeamInfo(id, Long.valueOf(MDC.get(X_USER_ID))));
    }

    @GetMapping("/favourite-team/fixtures")
    public ResponseEntity<ListBaseResponse<Fixture>> getFavTeamsFixtures() {
        return ResponseEntity.ok(favoriteTeamService.getFavoriteTeams(Long.valueOf(MDC.get(X_USER_ID))));
    }
}
