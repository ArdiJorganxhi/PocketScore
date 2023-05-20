package dev.ardijorganxhi.pocketscore.model.sportmonks.team;

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
public class Team {

    private Integer id;

    private String name;

    @JsonProperty("short_code")
    private String shortCode;

    private Integer founded;

    private String type;

    private List<Trophies> trophies;

    private List<Players> players;
}
