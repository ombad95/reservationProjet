package be.iccbxl.pid.reservationsspringboot.repository;

import be.iccbxl.pid.reservationsspringboot.model.Troupe;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TroupeRepository extends CrudRepository<Troupe, Long> {

}