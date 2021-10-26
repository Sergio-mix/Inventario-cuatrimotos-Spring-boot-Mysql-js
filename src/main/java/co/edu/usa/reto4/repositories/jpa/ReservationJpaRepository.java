package co.edu.usa.reto4.repositories.jpa;

import co.edu.usa.reto4.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationJpaRepository extends JpaRepository<Reservation, Long> {
}