package dev.ardijorganxhi.pocketscore.service;

import dev.ardijorganxhi.pocketscore.client.SportMonksClient;
import dev.ardijorganxhi.pocketscore.model.response.BaseResponse;
import dev.ardijorganxhi.pocketscore.model.response.ListBaseResponse;
import dev.ardijorganxhi.pocketscore.model.sportmonks.transfers.Transfer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class TransferServiceTest {

    @InjectMocks
    private TransferService transferService;

    @Mock
    private SportMonksClient sportMonksClient;


    @Test
    public void it_should_get_transfers() {
        Transfer transfer = Transfer.builder()
                .id(1)
                .build();

        List<Transfer> transfers = Collections.singletonList(transfer);

        ListBaseResponse<Transfer> transferResponse = ListBaseResponse.<Transfer>builder()
                .list(transfers)
                .build();

        when(sportMonksClient.getAllTransfers()).thenReturn(transferResponse);

        ListBaseResponse<Transfer> response = transferService.getTransfers();

        assertEquals(transferResponse, response);
        verify(sportMonksClient).getAllTransfers();
    }
    @Test
    public void it_should_get_transfer_by_id() {
        Long transferId = 1L;

        Transfer transfer = Transfer.builder()
                .id(Math.toIntExact(transferId))
                .build();

        BaseResponse<Transfer> transferResponse = BaseResponse.<Transfer>builder()
                .response(transfer)
                .build();

        when(sportMonksClient.getTransferById(transferId)).thenReturn(transferResponse);

        BaseResponse<Transfer> response = transferService.getTransferById(transferId);

        assertEquals(transferResponse, response);
        verify(sportMonksClient).getTransferById(transferId);

    }

    @Test
    public void it_should_get_transfers_by_team() {
        String teamName = "team";
        Transfer transfer = Transfer.builder()
                .id(1)
                .build();

        List<Transfer> transfers = Collections.singletonList(transfer);

        ListBaseResponse<Transfer> transferResponse = ListBaseResponse.<Transfer>builder()
                .list(transfers)
                .build();

        when(sportMonksClient.getTransferByTeams(teamName)).thenReturn(transferResponse);

        ListBaseResponse<Transfer> response = transferService.getTransferByTeam(teamName);

        assertEquals(transferResponse, response);
        verify(sportMonksClient).getTransferByTeams(teamName);
    }
}
