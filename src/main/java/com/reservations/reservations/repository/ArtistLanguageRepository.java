package com.reservations.reservations.repository;

import com.reservations.reservations.model.Artist;
import com.reservations.reservations.model.ArtistLanguage;
import com.reservations.reservations.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ArtistLanguageRepository extends JpaRepository<ArtistLanguage, Long> {
    List<ArtistLanguage> findByArtist(Artist artist);

    Optional<ArtistLanguage> findByArtistAndLanguage(Artist artist, Language language);

    @Query("SELECT al.artist FROM ArtistLanguage al WHERE al.language.language = :languageName AND al.level = 'FLUENT'")
    List<Artist> findArtistsFluentInLanguage(@Param("languageName") String languageName);
}