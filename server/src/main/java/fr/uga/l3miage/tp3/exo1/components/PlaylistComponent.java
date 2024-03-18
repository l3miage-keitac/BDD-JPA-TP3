package fr.uga.l3miage.tp3.exo1.components;

import fr.uga.l3miage.tp3.exo1.models.PlaylistEntity;
import fr.uga.l3miage.tp3.exo1.models.SongEntity;
import fr.uga.l3miage.tp3.exo1.repositories.PlaylistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class PlaylistComponent {
    private final PlaylistRepository playlistRepository;

    private PlaylistEntity createPlaylist(String name, String description, Duration totalDuration, Set<SongEntity> songEntities){
        PlaylistEntity playlistEntity = PlaylistEntity
                .builder()
                .name(name)
                .description(description)
                .totalDuration(totalDuration)
                .songEntities(Set.of())
                .build();
        return playlistRepository.save(playlistEntity);
    }
    public PlaylistEntity updateTotalDuration(String name, Duration totalDuration){
        PlaylistEntity playlistEntity = playlistRepository.findById(name).orElseThrow();
        playlistEntity.setTotalDuration(totalDuration);
        return playlistRepository.save(playlistEntity);
    }
}
