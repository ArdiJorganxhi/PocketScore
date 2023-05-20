package dev.ardijorganxhi.pocketscore.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "favourite_teams")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FavoriteTeam {

    @Id
    private Integer id;

    @Column(name = "team_name", nullable = false)
    private String teamName;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;
}
