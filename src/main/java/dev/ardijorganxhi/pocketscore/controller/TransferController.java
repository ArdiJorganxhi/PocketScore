package dev.ardijorganxhi.pocketscore.controller;

import dev.ardijorganxhi.pocketscore.model.response.BaseResponse;
import dev.ardijorganxhi.pocketscore.model.response.ListBaseResponse;
import dev.ardijorganxhi.pocketscore.model.sportmonks.transfers.Transfer;
import dev.ardijorganxhi.pocketscore.service.TransferService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transfers")
@RequiredArgsConstructor
public class TransferController {

    private final TransferService transferService;

    @GetMapping
    public ResponseEntity<ListBaseResponse<Transfer>> getAllTransfers() {
        return ResponseEntity.ok(transferService.getTransfers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse<Transfer>> getTransferById(@PathVariable Long id) {
        return ResponseEntity.ok(transferService.getTransferById(id));
    }

    @GetMapping("/{team}")
    public ResponseEntity<ListBaseResponse<Transfer>> getTransferByTeam(@PathVariable String team) {
        return ResponseEntity.ok(transferService.getTransferByTeam(team));
    }





}
