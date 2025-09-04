package com.reservations.reservations.service;

import com.reservations.reservations.model.Language;
import com.reservations.reservations.repository.LanguageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageService {
    private final LanguageRepository languageRepository;

    public LanguageService(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    public List<Language> getAllLanguages() {
        return languageRepository.findAllByOrderByLanguageAsc();
    }

    public Language getLanguage(Long id) {
        return languageRepository.findById(id).orElse(null);
    }

    public Language saveLanguage(Language language) {
        return languageRepository.save(language);
    }

    public Language findOrCreate(String languageName) {
        return languageRepository.findByLanguage(languageName)
                .orElseGet(() -> {
                    Language newLanguage = new Language(languageName);
                    return languageRepository.save(newLanguage);
                });
    }
}