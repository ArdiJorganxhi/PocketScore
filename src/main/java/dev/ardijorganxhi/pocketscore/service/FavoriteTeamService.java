package dev.ardijorganxhi.pocketscore.service;

import dev.ardijorganxhi.pocketscore.entity.FavoriteTeam;
import dev.ardijorganxhi.pocketscore.mapper.UserMapper;
import dev.ardijorganxhi.pocketscore.model.sportmonks.response.TeamResponse;
import dev.ardijorganxhi.pocketscore.model.sportmonks.team.Team;
import dev.ardijorganxhi.pocketscore.repository.FavoriteTeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FavoriteTeamService {

    private final FavoriteTeamRepository favoriteTeamRepository;
    private final UserMapper userMapper;

    public void addFavoriteTeam(Team team, Long userId) {
        final FavoriteTeam favoriteTeam = userMapper.addFavoriteTeam(team, userId);
        favoriteTeamRepository.save(favoriteTeam);
    }


}
