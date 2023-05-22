package dev.ardijorganxhi.pocketscore.client;


import dev.ardijorganxhi.pocketscore.model.response.BaseResponse;
import dev.ardijorganxhi.pocketscore.model.response.ListBaseResponse;
import dev.ardijorganxhi.pocketscore.model.sportmonks.players.Player;
import dev.ardijorganxhi.pocketscore.model.sportmonks.scores.Fixture;
import dev.ardijorganxhi.pocketscore.model.sportmonks.standings.Standings;
import dev.ardijorganxhi.pocketscore.model.sportmonks.team.Squads;
import dev.ardijorganxhi.pocketscore.model.sportmonks.team.Team;
import dev.ardijorganxhi.pocketscore.model.sportmonks.transfers.Transfer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

    @GetMapping("/players/{playerId}?api_token=${token}&include=statistics;")
    BaseResponse<Player> getStatsByPlayerId(@PathVariable Long playerId);

    @GetMapping("/players/{playerId}?api_token=${token}&include=trophies;")
    BaseResponse<Player> getTrophiesByPlayerId(@PathVariable Long playerId);

    @GetMapping("/teams?api_token=${token}")
    ListBaseResponse<Team> getAllTeams();

    @GetMapping("/teams/{teamId}?api_token=${token}")
    BaseResponse<Team> getTeamById(@PathVariable Long teamId);

    @GetMapping("/squads/teams/{teamId}?api_token=${token}")
    ListBaseResponse<Squads> getSquadsOfTeamById(@PathVariable Long teamId);

    @GetMapping("/teams/{teamId}?api_token=${token}&include=seasons;")
    BaseResponse<Team> getSeasonsOfTeamById(@PathVariable Long teamId);

    @GetMapping("/teams/{teamId}?api_token=${token}&include=rivals;")
    BaseResponse<Team> getRivalsOfTeamById(@PathVariable Long teamId);



}
