package dev.ardijorganxhi.pocketscore.service;

import dev.ardijorganxhi.pocketscore.client.SportMonksClient;
import dev.ardijorganxhi.pocketscore.model.response.BaseResponse;
import dev.ardijorganxhi.pocketscore.model.response.ListBaseResponse;
import dev.ardijorganxhi.pocketscore.model.sportmonks.players.Player;
import dev.ardijorganxhi.pocketscore.model.sportmonks.players.PlayerStats;
import dev.ardijorganxhi.pocketscore.model.sportmonks.players.PlayerTrophies;
import org.checkerframework.checker.nullness.Opt;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class PlayerServiceTest {

    @InjectMocks
    private PlayerService playerService;

    @Mock
    private SportMonksClient sportMonksClient;


    @Test
    public void it_should_get_all_scores() {
        Player player = Player.builder()
                .id(1)
                .name("player")
                .build();
        Player player1 = Player.builder()
                .id(2)
                .name("player2")
                .build();

        List<Player> players = List.of(player, player1);

        ListBaseResponse<Player> playersList = ListBaseResponse.<Player>builder()
                .list(players)
                .build();

        when(sportMonksClient.getAllPlayers()).thenReturn(playersList);

        ListBaseResponse<Player> response = playerService.getAllPlayers();

        assertEquals(response, playersList);
        verify(sportMonksClient).getAllPlayers();

    }

    @Test
    public void it_should_get_player_by_id() {
        Integer playerId = 1;

        Player player = Player.builder()
                .id(playerId)
                .name("player")
                .build();

        BaseResponse<Player> playerBaseResponse = BaseResponse.<Player>builder()
                .response(player)
                .build();

        when(sportMonksClient.getPlayerById(Long.valueOf(playerId))).thenReturn(playerBaseResponse);

        BaseResponse<Player> response = playerService.getPlayerById(Long.valueOf(playerId));

        assertEquals(response, playerBaseResponse);
        verify(sportMonksClient).getPlayerById(Long.valueOf(playerId));
    }

    @Test
    public void it_should_get_players_by_countryid() {
        Integer countryId = 1;

        Player player = Player.builder()
                .id(1)
                .name("player")
                .countryId(countryId)
                .build();

        List<Player> players = Collections.singletonList(player);

        ListBaseResponse<Player> playerListBaseResponse = ListBaseResponse.<Player>builder()
                .list(players)
                .build();

        when(sportMonksClient.getPlayersByCountryId(Long.valueOf(countryId))).thenReturn(playerListBaseResponse);

        ListBaseResponse<Player> response = playerService.getPlayersByCountryId(Long.valueOf(countryId));

        assertEquals(response, playerListBaseResponse);
        verify(sportMonksClient).getPlayersByCountryId(Long.valueOf(countryId));
    }

    @Test
    public void it_should_get_player_by_search() {
        String name = "player";

        Player player = Player.builder()
                .name(name)
                .build();

        List<Player> players = Collections.singletonList(player);

        ListBaseResponse<Player> playerListBaseResponse = ListBaseResponse.<Player>builder()
                .list(players)
                .build();

        when(sportMonksClient.getPlayerBySearch(name)).thenReturn(playerListBaseResponse);

        ListBaseResponse<Player> response = playerService.getPlayerBySearch(name);

        assertEquals(response, playerListBaseResponse);
        verify(sportMonksClient).getPlayerBySearch(name);
    }

    @Test
    public void it_should_get_stats_by_player() {
        Integer playerId = 1;

        PlayerStats playerStats = PlayerStats.builder()
                .id(1)
                .playerId(playerId)
                .build();

        Optional<List<PlayerStats>> playerStatsList = Optional.of(Collections.singletonList(playerStats));

        Player player = Player.builder()
                .id(playerId)
                .statistics(playerStatsList)
                .build();

        BaseResponse<Player> playerBaseResponse = BaseResponse.<Player>builder()
                .response(player)
                .build();

        when(sportMonksClient.getStatsByPlayerId(Long.valueOf(playerId))).thenReturn(playerBaseResponse);

        Optional<List<PlayerStats>> response = Optional.ofNullable(playerService.getStatsByPlayer(Long.valueOf(playerId)));

        assertEquals(response, playerBaseResponse.getResponse().getStatistics());
        verify(sportMonksClient).getStatsByPlayerId(Long.valueOf(playerId));

    }

    @Test
    public void it_should_get_trophies_by_player() {
        Integer playerId = 1;

        PlayerTrophies playerTrophies = PlayerTrophies.builder()
                .id(1)
                .playerId(playerId)
                .build();

        Optional<List<PlayerTrophies>> playerTrophies1 = Optional.of(Collections.singletonList(playerTrophies));

        Player player = Player.builder()
                .id(playerId)
                .trophies(playerTrophies1)
                .build();

        BaseResponse<Player> playerBaseResponse = BaseResponse.<Player>builder()
                .response(player)
                .build();

        when(sportMonksClient.getTrophiesByPlayerId(Long.valueOf(playerId))).thenReturn(playerBaseResponse);

        Optional<List<PlayerTrophies>> response = Optional.ofNullable(playerService.getTrophiesByPlayer(Long.valueOf(playerId)));

        assertEquals(response, playerBaseResponse.getResponse().getTrophies());
        verify(sportMonksClient).getTrophiesByPlayerId(Long.valueOf(playerId));
    }
}
