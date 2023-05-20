package dev.ardijorganxhi.pocketscore.model.sportmonks.team;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Trophies {

    private Long id;
    @JsonProperty("league_id")
    private Integer leagueId;

    @JsonProperty("season_id")
    private Integer seasonId;

    @JsonProperty("trophy_id")
    private Integer trophyId;
}
