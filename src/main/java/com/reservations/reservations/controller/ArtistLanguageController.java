package com.reservations.reservations.controller;

import com.reservations.reservations.model.Artist;
import com.reservations.reservations.service.ArtistLanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/artists")
public class ArtistLanguageController {

    @Autowired
    private ArtistLanguageService artistLanguageService;

    @GetMapping("/fluent-in/{language}")
    public String getArtistsFluentInLanguage(@PathVariable String language, Model model) {
        List<Artist> artists = artistLanguageService.getArtistsFluentInLanguage(language);

        model.addAttribute("artists", artists);
        model.addAttribute("language", language);
        model.addAttribute("title", "Artistes parlant couramment " + language);

        return "artist/fluent-list";
    }
}