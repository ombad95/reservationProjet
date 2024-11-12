package com.SiteReservation.ProjetSpringBootReservation.repository;
import java.util.List;
import com.SiteReservation.ProjetSpringBootReservation.model.Artist;
import org.springframework.data.repository.CrudRepository;

public interface ArtistRepository extends CrudRepository<Artist, Long> {
    List<Artist> findByLastname(String lastname);

    Artist findById(long id);
}
