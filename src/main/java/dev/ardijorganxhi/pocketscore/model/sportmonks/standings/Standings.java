package dev.ardijorganxhi.pocketscore.model.sportmonks.standings;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Standings {
    private Integer id;

    @JsonProperty("league_id")
    private Integer leagueId;

    @JsonProperty("season_id")
    private Integer seasonId;

    @JsonProperty("participant_id")
    private Integer participantId;

    private Integer position;

    private Integer points;
}
