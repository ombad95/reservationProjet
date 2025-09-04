package com.reservations.reservations.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "artists")
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "The firstname must not be empty.")
    @Size(min = 2, max = 60, message = "The firstname must be between 2 and 60 characters long.")
    private String firstname;

    @NotBlank(message = "The lastname must not be empty.")
    @Size(min = 2, max = 60, message = "The firstname must be between 2 and 60 characters long.")
    private String lastname;

    @ManyToMany(mappedBy = "artists")
    private List<Type> types = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public List<Type> getTypes() {
        return types;
    }

    public Artist addType(Type type) {
        if (!this.types.contains(type)) {
            this.types.add(type);
            type.addArtist(this);
        }

        return this;
    }

    public Artist removeType(Type type) {
        if (this.types.contains(type)) {
            this.types.remove(type);
            type.getArtists().remove(this);
        }

        return this;
    }

    @Override
    public String toString() {
        return firstname + " " + lastname;
    }
    @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ArtistLanguage> languages = new HashSet<>();


    public Set<ArtistLanguage> getLanguages() {
        return languages;
    }

    public void addLanguage(Language language, Level level) {
        ArtistLanguage artistLanguage = new ArtistLanguage(this, language, level);
        this.languages.add(artistLanguage);
        language.getArtistLanguages().add(artistLanguage);
    }

    public void removeLanguage(Language language) {
        ArtistLanguage artistLanguage = this.languages.stream()
                .filter(al -> al.getLanguage().equals(language))
                .findFirst()
                .orElse(null);
        if (artistLanguage != null) {
            this.languages.remove(artistLanguage);
            language.getArtistLanguages().remove(artistLanguage);
            artistLanguage.setArtist(null);
            artistLanguage.setLanguage(null);
        }
    }

    public boolean isComedian() {
        return types.stream()
                .anyMatch(type -> "Comédien".equalsIgnoreCase(type.getType()));
    }
}
