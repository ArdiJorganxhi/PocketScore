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
public class Players {

    private Integer id;

    @JsonProperty("player_id")
    private Integer playerId;

    @JsonProperty("position_id")
    private Integer positionId;

    @JsonProperty("detailed_position_id")
    private Integer detailedPositionId;

    @JsonProperty("start")
    private String contractStartDate;

    @JsonProperty("end")
    private String contractEndDate;

    @JsonProperty("jersey_number")
    private Integer jerseyNumber;
}
