package dev.ardijorganxhi.pocketscore.service;

import dev.ardijorganxhi.pocketscore.client.SportMonksClient;
import dev.ardijorganxhi.pocketscore.model.sportmonks.players.Player;
import dev.ardijorganxhi.pocketscore.model.sportmonks.response.BaseResponse;
import dev.ardijorganxhi.pocketscore.model.sportmonks.response.ListBaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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


}
