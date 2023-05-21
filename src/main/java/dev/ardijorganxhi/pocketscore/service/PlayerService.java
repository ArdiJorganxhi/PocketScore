package dev.ardijorganxhi.pocketscore.service;

import dev.ardijorganxhi.pocketscore.client.SportMonksClient;
import dev.ardijorganxhi.pocketscore.model.sportmonks.players.Player;
import dev.ardijorganxhi.pocketscore.model.sportmonks.players.PlayerStats;
import dev.ardijorganxhi.pocketscore.model.sportmonks.players.PlayerTrophies;
import dev.ardijorganxhi.pocketscore.model.sportmonks.response.BaseResponse;
import dev.ardijorganxhi.pocketscore.model.sportmonks.response.ListBaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerService {

    private final SportMonksClient sportMonksClient;

    public ListBaseResponse<Player> getAllPlayers() {
        return sportMonksClient.getAllPlayers();
    }

    public BaseResponse<Player> getPlayerById(Long playerId) {
        return sportMonksClient.getPlayerById(playerId);
    }

    public ListBaseResponse<Player> getPlayersByCountryId(Long countryId) {
        return sportMonksClient.getPlayersByCountryId(countryId);
    }
    public ListBaseResponse<Player> getPlayerBySearch(String name) {
        return sportMonksClient.getPlayerBySearch(name);
    }

    public List<PlayerStats> getStatsByPlayer(Long id) {
        final BaseResponse<Player> player = sportMonksClient.getStatsByPlayerId(id);
        return player.getResponse().getStatistics().orElseThrow();
    }
    public List<PlayerTrophies> getTrophiesByPlayer(Long id) {
        final BaseResponse<Player> player = sportMonksClient.getTrophiesByPlayerId(id);
        return player.getResponse().getTrophies().orElseThrow();
    }


}
