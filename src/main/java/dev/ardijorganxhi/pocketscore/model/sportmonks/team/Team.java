package dev.ardijorganxhi.pocketscore.model.sportmonks.team;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;
import java.util.Optional;

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

    private Optional<List<Trophies>> trophies;

    private Optional<List<Squads>> players;

    private Optional<List<TeamSeasons>> seasons;

    private Optional<List<Team>> rivals;
}
