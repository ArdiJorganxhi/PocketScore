package dev.ardijorganxhi.pocketscore.client;


import dev.ardijorganxhi.pocketscore.model.sportmonks.players.Player;
import dev.ardijorganxhi.pocketscore.model.sportmonks.response.*;
import dev.ardijorganxhi.pocketscore.model.sportmonks.scores.Fixture;
import dev.ardijorganxhi.pocketscore.model.sportmonks.standings.Standings;
import dev.ardijorganxhi.pocketscore.model.sportmonks.team.Team;
import dev.ardijorganxhi.pocketscore.model.sportmonks.transfers.Transfer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "sportmonksclient", url = "https://api.sportmonks.com/v3/football")
public interface SportMonksClient {
    @GetMapping("/fixtures?api_token=${token}&include=scores")
    ListBaseResponse<Fixture> getScores();

    @GetMapping("/standings/live/leagues/{leagueId}?api_token=${token}")
    ListBaseResponse<Standings> getStandings(@PathVariable Long leagueId);

    @GetMapping("/teams/search/{team}?api_token=${token}&include=trophies;players;")
    ListBaseResponse<Team> getTeam(@PathVariable String team);

    @GetMapping("/fixtures/multi/{teams}?api_token=${token}")
    ListBaseResponse<Fixture> getFavTeamsFixture(@PathVariable String teams);

    @GetMapping("/transfers?api_token=${token}")
    ListBaseResponse<Transfer> getAllTransfers();

    @GetMapping("/transfers/{transferId}?api_token=${token}")
    BaseResponse<Transfer> getTransferById(@PathVariable Long transferId);

    @GetMapping("//transfers/teams/{team}?api_token=${token}")
    ListBaseResponse<Transfer> getTransferByTeams(@PathVariable String team);

    @GetMapping("/players?api_token=${token}")
    ListBaseResponse<Player> getAllPlayers();

    @GetMapping("/players/{playerId}?api_token=${token}")
    BaseResponse<Player> getPlayerById(@PathVariable Long playerId);

    @GetMapping("/players/countries/{countryId}?api_token=${token}")
    ListBaseResponse<Player> getPlayersByCountryId(@PathVariable Long countryId);

    @GetMapping("/players/search/{player}?api_token=${token}")
    ListBaseResponse<Player> getPlayerBySearch(@PathVariable String player);

}
