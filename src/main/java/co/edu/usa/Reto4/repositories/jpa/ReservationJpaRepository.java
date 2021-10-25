package co.edu.usa.Reto4.repositories.jpa;

import co.edu.usa.Reto4.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationJpaRepository extends JpaRepository<Reservation, Long> {
}
