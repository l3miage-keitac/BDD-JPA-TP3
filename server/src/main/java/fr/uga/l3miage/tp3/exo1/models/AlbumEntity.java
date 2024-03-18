package fr.uga.l3miage.tp3.exo1.models;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AlbumEntity {
    @Id
    private String title;

    private Date releaseDate;

    @OneToMany(mappedBy = "albumEntity",cascade = CascadeType.ALL)
    private Set<SongEntity> songEntities;

    @ManyToOne
    private ArtistEntity artistEntity;
}
