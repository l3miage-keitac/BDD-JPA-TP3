package fr.uga.l3miage.tp3.exo1.components;

import fr.uga.l3miage.tp3.exo1.models.AlbumEntity;
import fr.uga.l3miage.tp3.exo1.models.ArtistEntity;
import fr.uga.l3miage.tp3.exo1.models.SongEntity;
import fr.uga.l3miage.tp3.exo1.repositories.SongRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class SongComponent {
    private final SongRepository songRepository;

    public SongEntity createSong(String title, Duration duration, AlbumEntity albumEntity, ArtistEntity artistEntity){
        SongEntity songEntity = SongEntity
                .builder()
                .title(title)
                .duration(duration)
                .albumEntity(albumEntity)
                .artistEntity(artistEntity)
                .build();
        return songRepository.save(songEntity);
    }

    public SongEntity updateDuration(String title, Duration newDuration){
        SongEntity songEntity = songRepository.findById(title).orElseThrow();
        songEntity.setDuration(newDuration);
        return songRepository.save(songEntity);
    }

    public void deleteSong(String title){
        songRepository.deleteById(title);
    }

    public SongEntity getSongEntity (Duration duration1, Duration duration2){
        return songRepository.findByDurationBetween(duration1, duration2);
    }
}
