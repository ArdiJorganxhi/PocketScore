package dev.ardijorganxhi.pocketscore.model.sportmonks.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.ardijorganxhi.pocketscore.model.sportmonks.scores.Fixture;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ScoreResponse {

    private List<Fixture> data;
}
