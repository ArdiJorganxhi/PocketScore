package dev.ardijorganxhi.pocketscore.client;

import dev.ardijorganxhi.pocketscore.model.sportmonks.response.Fixture;
import dev.ardijorganxhi.pocketscore.model.sportmonks.response.ScoreResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "sportmonksclient", url = "https://api.sportmonks.com/v3")
public interface SportMonksClient {
    @GetMapping("/football/fixtures?api_token=${token}&include=scores")
    ScoreResponse getScores();
}
