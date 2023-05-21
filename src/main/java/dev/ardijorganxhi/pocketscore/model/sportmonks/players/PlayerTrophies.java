package dev.ardijorganxhi.pocketscore.model.sportmonks.players;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.criteria.CriteriaBuilder;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayerTrophies {

    private Integer id;

    @JsonProperty("participant_id")
    private Integer playerId;

    @JsonProperty("team_id")
    private Integer teamId;

    @JsonProperty("league_id")
    private Integer leagueId;

    @JsonProperty("season_id")
    private Integer seasonId;

    @JsonProperty("trophy_id")
    private Integer trophyId;
}
