package dev.ardijorganxhi.pocketscore.controller;

import dev.ardijorganxhi.pocketscore.model.sportmonks.response.ListTransferResponse;
import dev.ardijorganxhi.pocketscore.model.sportmonks.response.TransferResponse;
import dev.ardijorganxhi.pocketscore.service.SportMonksService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/transfers")
@RequiredArgsConstructor
public class TransferController {

    private final SportMonksService sportMonksService;

    @GetMapping
    public ResponseEntity<ListTransferResponse> getAllTransfers() {
        return ResponseEntity.ok(sportMonksService.getTransfers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransferResponse> getTransferById(@PathVariable Long id) {
        return ResponseEntity.ok(sportMonksService.getTransferById(id));
    }

    @GetMapping("/{team}")
    public ResponseEntity<ListTransferResponse> getTransferByTeam(@PathVariable String team) {
        return ResponseEntity.ok(sportMonksService.getTransferByTeam(team));
    }





}
