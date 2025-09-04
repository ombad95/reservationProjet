package com.reservations.reservations.service;

import com.reservations.reservations.model.Artist;
import com.reservations.reservations.model.ArtistLanguage;
import com.reservations.reservations.model.Language;
import com.reservations.reservations.model.Level;
import com.reservations.reservations.repository.ArtistLanguageRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ArtistLanguageService {
    private final ArtistLanguageRepository artistLanguageRepository;

    public ArtistLanguageService(ArtistLanguageRepository artistLanguageRepository) {
        this.artistLanguageRepository = artistLanguageRepository;
    }

    public List<ArtistLanguage> getLanguagesByArtist(Artist artist) {
        return artistLanguageRepository.findByArtist(artist);
    }

    public ArtistLanguage addLanguageToArtist(Artist artist, Language language, Level level) {
        ArtistLanguage artistLanguage = new ArtistLanguage(artist, language, level);
        return artistLanguageRepository.save(artistLanguage);
    }

    public void removeLanguageFromArtist(Artist artist, Language language) {
        artistLanguageRepository.findByArtistAndLanguage(artist, language)
                .ifPresent(artistLanguageRepository::delete);
    }

    public List<Artist> getArtistsFluentInLanguage(String languageName) {
        return artistLanguageRepository.findArtistsFluentInLanguage(languageName);
    }
}