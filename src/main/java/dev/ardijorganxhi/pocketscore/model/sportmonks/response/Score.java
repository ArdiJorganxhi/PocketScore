package dev.ardijorganxhi.pocketscore.model.sportmonks.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Score {

    private Integer id;

    @JsonProperty("fixture_id")
    private Integer fixtureId;

    @JsonProperty("participant_id")
    private Integer participantId;

    private ScoreInfo score;

    private String description;

}
