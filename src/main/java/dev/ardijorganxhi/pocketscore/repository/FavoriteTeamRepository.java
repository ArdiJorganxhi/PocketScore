package dev.ardijorganxhi.pocketscore.repository;

import dev.ardijorganxhi.pocketscore.entity.FavoriteTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoriteTeamRepository extends JpaRepository<FavoriteTeam, Integer> {
}
