package dev.ardijorganxhi.pocketscore.service;

import dev.ardijorganxhi.pocketscore.client.SportMonksClient;
import dev.ardijorganxhi.pocketscore.model.response.BaseResponse;
import dev.ardijorganxhi.pocketscore.model.response.ListBaseResponse;
import dev.ardijorganxhi.pocketscore.model.sportmonks.transfers.Transfer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransferService {

    private final SportMonksClient sportMonksClient;

    public ListBaseResponse<Transfer> getTransfers() {
        return sportMonksClient.getAllTransfers();
    }

    public BaseResponse<Transfer> getTransferById(Long transferId) {
        return sportMonksClient.getTransferById(transferId);
    }
    public ListBaseResponse<Transfer> getTransferByTeam(String team) {
        return sportMonksClient.getTransferByTeams(team);
    }
}

