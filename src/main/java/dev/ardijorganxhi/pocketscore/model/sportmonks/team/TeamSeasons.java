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
public class TeamSeasons {

    private Integer id;

    @JsonProperty("league_id")
    private Integer leagueId;

    @JsonProperty("tie_breaker_rule_id")
    private Integer tieBreakerRuleId;

    private String name;


}
