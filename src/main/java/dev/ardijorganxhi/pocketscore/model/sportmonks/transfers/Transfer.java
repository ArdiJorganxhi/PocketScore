package dev.ardijorganxhi.pocketscore.model.sportmonks.transfers;

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
public class Transfer {

    private Integer id;

    @JsonProperty("player_id")
    private Integer playerId;

    @JsonProperty("type_id")
    private Integer typeId;

    @JsonProperty("from_team_id")
    private Integer fromTeam;

    @JsonProperty("to_team_id")
    private Integer toTeam;

    @JsonProperty("position_id")
    private Integer position;

    private String date;

    private boolean completed;
}
