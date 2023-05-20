package dev.ardijorganxhi.pocketscore.model.sportmonks.scores;

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
public class Fixture {

    private Integer id;
    private String name;
    @JsonProperty("result_info")
    private String resultInfo;
    @JsonProperty("scores")
    private List<Score> scoreList;




}
