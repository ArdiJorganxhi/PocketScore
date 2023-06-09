package dev.ardijorganxhi.pocketscore.service;

import dev.ardijorganxhi.pocketscore.client.SportMonksClient;
import dev.ardijorganxhi.pocketscore.entity.FavoriteTeam;
import dev.ardijorganxhi.pocketscore.mapper.UserMapper;
import dev.ardijorganxhi.pocketscore.model.response.ListBaseResponse;
import dev.ardijorganxhi.pocketscore.model.sportmonks.scores.Fixture;
import dev.ardijorganxhi.pocketscore.model.sportmonks.team.Team;
import dev.ardijorganxhi.pocketscore.repository.FavoriteTeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FavoriteTeamService {

    private final FavoriteTeamRepository favoriteTeamRepository;
    private final UserMapper userMapper;
    private final SportMonksClient sportMonksClient;

    public void addFavoriteTeam(String team, Long userId) {
        final ListBaseResponse<Team> response = sportMonksClient.getTeam(team);
        final FavoriteTeam favoriteTeam = userMapper.addFavoriteTeam(response.getList().get(0), userId);
        favoriteTeamRepository.save(favoriteTeam);
    }

    public ListBaseResponse<Team> getFavoriteTeamInfo(Integer id, Long userId) {
        final FavoriteTeam favoriteTeam = favoriteTeamRepository.findByIdAndUserId(id, userId).orElseThrow();
        return sportMonksClient.getTeam(favoriteTeam.getTeamName());
    }

    public ListBaseResponse<Fixture> getFavoriteTeams(Long userId) {
        final List<FavoriteTeam> favoriteTeams = favoriteTeamRepository.findByUserId(userId);
        final List<Integer> teamsId = favoriteTeams.stream().map(FavoriteTeam::getId).toList();
        final String teams = StringUtils.collectionToDelimitedString(teamsId, ",");
        return sportMonksClient.getFavTeamsFixture(teams);
    }


}
