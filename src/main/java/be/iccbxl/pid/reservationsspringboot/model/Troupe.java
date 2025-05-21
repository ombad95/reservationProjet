package be.iccbxl.pid.reservationsspringboot.model;

import com.reservations.reservations.model.Artist;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "troupe")
public class Troupe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String logoUrl;

    // Relation avec les artistes
    @OneToMany(mappedBy = "troupe", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<com.reservations.reservations.model.Artist> artists = new ArrayList<>();

    public void addArtist(com.reservations.reservations.model.Artist artist) {
        artists.add(artist);
        artist.setTroupe(this);
    }

    public void removeArtist(Artist artist) {
        artists.remove(artist);
        artist.setTroupe(null);
    }
}
