package co.edu.usa.Reto3.repository;

import co.edu.usa.Reto3.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
