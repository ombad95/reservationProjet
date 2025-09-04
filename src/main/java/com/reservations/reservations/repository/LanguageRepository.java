package com.reservations.reservations.repository;

import com.reservations.reservations.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LanguageRepository extends JpaRepository<Language, Long> {
    List<Language> findAllByOrderByLanguageAsc();

    Optional<Language> findByLanguage(String language);
}