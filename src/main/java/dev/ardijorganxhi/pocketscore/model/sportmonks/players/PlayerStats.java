package dev.ardijorganxhi.pocketscore.model.sportmonks.players;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayerStats {

    private Integer id;

    @JsonProperty("player_id")
    private Integer playerId;

    @JsonProperty("team_id")
    private Integer teamId;

    @JsonProperty("season_id")
    private Integer seasonId;

}
