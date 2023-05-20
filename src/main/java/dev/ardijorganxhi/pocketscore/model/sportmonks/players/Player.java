package dev.ardijorganxhi.pocketscore.model.sportmonks.players;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Player {

    private Integer id;

    @JsonProperty("country_id")
    private Integer countryId;

    @JsonProperty("nationality_id")
    private Integer nationalityId;

    @JsonProperty("position_id")
    private Integer positionId;

    private String name;

    @JsonProperty("display_name")
    private String displayName;

    @JsonProperty("date_of_birth")
    private String dateOfBirth;


}
