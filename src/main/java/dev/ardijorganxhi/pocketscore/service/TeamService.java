package dev.ardijorganxhi.pocketscore.service;

import dev.ardijorganxhi.pocketscore.client.SportMonksClient;
import dev.ardijorganxhi.pocketscore.model.response.BaseResponse;
import dev.ardijorganxhi.pocketscore.model.response.ListBaseResponse;
import dev.ardijorganxhi.pocketscore.model.sportmonks.team.Squads;
import dev.ardijorganxhi.pocketscore.model.sportmonks.team.Team;
import dev.ardijorganxhi.pocketscore.model.sportmonks.team.TeamSeasons;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamService {

    private final SportMonksClient sportMonksClient;

    public ListBaseResponse<Team> getAllTeams() {
        return sportMonksClient.getAllTeams();
    }

    public BaseResponse<Team> getTeamById(Long id) {
        return sportMonksClient.getTeamById(id);
    }

    public ListBaseResponse<Squads> getSquadsOfTeamById(Long id) {
        return sportMonksClient.getSquadsOfTeamById(id);
    }

    public List<TeamSeasons> getSeasonsOfTeamById(Long id) {
        final BaseResponse<Team> team = sportMonksClient.getSeasonsOfTeamById(id);
        return team.getResponse().getSeasons().orElseThrow();
    }

    public List<Team> getRivalsOfTeamById(Long id) {
        final BaseResponse<Team> team = sportMonksClient.getRivalsOfTeamById(id);
        return team.getResponse().getRivals().orElseThrow();
    }


}
