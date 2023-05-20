package dev.ardijorganxhi.pocketscore.controller;

import dev.ardijorganxhi.pocketscore.client.SportMonksClient;
import dev.ardijorganxhi.pocketscore.model.dto.UserDto;
import dev.ardijorganxhi.pocketscore.model.sportmonks.response.TeamResponse;
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
        TeamResponse response = sportMonksClient.getTeam(team);
        favoriteTeamService.addFavoriteTeam(response.getTeam().get(0), Long.valueOf(MDC.get(X_USER_ID)));

    }
}
