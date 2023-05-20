package dev.ardijorganxhi.pocketscore.model.sportmonks.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.ardijorganxhi.pocketscore.model.sportmonks.scores.Fixture;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ScoreResponse {

    private List<Fixture> data;
}
