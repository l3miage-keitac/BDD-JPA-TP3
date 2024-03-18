package fr.uga.l3miage.tp3.exo1.components;

import fr.uga.l3miage.tp3.exo1.enums.GenreMusical;
import fr.uga.l3miage.tp3.exo1.models.AlbumEntity;
import fr.uga.l3miage.tp3.exo1.models.ArtistEntity;
import fr.uga.l3miage.tp3.exo1.repositories.ArtistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class ArtistComponent {
    private final ArtistRepository artistRepository;

    public ArtistEntity createArtist(String name, String biography, GenreMusical genre, Set<AlbumEntity> albumEntities){
        ArtistEntity artistEntity = ArtistEntity
                .builder()
                .name(name)
                .biography(biography)
                .genreMusical(genre)
                .albumEntities(Set.of())
                .build();
        return artistRepository.save(artistEntity);
    }

    public ArtistEntity updateBiography(String name, String biography){
        ArtistEntity artistEntity = artistRepository.findById(name).orElseThrow();
        artistEntity.setBiography(biography);
        return artistRepository.save(artistEntity);
    }

    public void deleteArtist(String name){
         artistRepository.deleteById(name);
    }
    public int getCountArtisteGroupByGenre(GenreMusical genreMusical){
        return artistRepository.countAllByGenreMusical(genreMusical);
    }
}
