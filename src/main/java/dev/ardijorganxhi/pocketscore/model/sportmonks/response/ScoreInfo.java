package dev.ardijorganxhi.pocketscore.model.sportmonks.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ScoreInfo {

    private Integer goals;

    private String participant;
}
