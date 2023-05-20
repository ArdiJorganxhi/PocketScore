package dev.ardijorganxhi.pocketscore.repository;

import dev.ardijorganxhi.pocketscore.entity.FavoriteTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FavoriteTeamRepository extends JpaRepository<FavoriteTeam, Integer> {

    Optional<FavoriteTeam> findByIdAndUserId(Integer id, Long userId);
    List<FavoriteTeam> findByUserId(Long userId);
}
