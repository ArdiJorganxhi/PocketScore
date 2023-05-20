package dev.ardijorganxhi.pocketscore.model.sportmonks.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dev.ardijorganxhi.pocketscore.model.sportmonks.transfers.Transfer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransferResponse {

    private Transfer transfer;
}
