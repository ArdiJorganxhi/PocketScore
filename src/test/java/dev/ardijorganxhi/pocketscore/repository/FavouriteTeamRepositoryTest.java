package dev.ardijorganxhi.pocketscore.repository;

import dev.ardijorganxhi.pocketscore.entity.FavoriteTeam;
import dev.ardijorganxhi.pocketscore.service.FavoriteTeamService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class FavouriteTeamRepositoryTest {

    @Mock
    private FavoriteTeamRepository favoriteTeamRepository;

    @InjectMocks
    private FavoriteTeamService favoriteTeamService;

    @Test
    public void it_should_find_by_id_and_userid() {
        Integer id = 1;
        Long userId = 1L;

        FavoriteTeam favoriteTeam = FavoriteTeam.builder()
                .id(id)
                .userId(userId)
                .build();

        when(favoriteTeamRepository.findByIdAndUserId(id, userId)).thenReturn(Optional.of(favoriteTeam));

    }

    @Test
    public void it_should_find_by_userid() {
        Long userId = 1L;

        FavoriteTeam favoriteTeam = FavoriteTeam.builder()
                .teamName("favoriteteam")
                .userId(userId)
                .build();
        FavoriteTeam favoriteTeam1 = FavoriteTeam.builder()
                .teamName("favoriteteam2")
                .userId(userId)
                .build();

        List<FavoriteTeam> favoriteTeams = List.of(favoriteTeam, favoriteTeam1);

        when(favoriteTeamRepository.findByUserId(userId)).thenReturn(favoriteTeams);
    }
}
