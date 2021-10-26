package co.edu.usa.reto4.repositories;

import co.edu.usa.reto4.model.Reservation;
import co.edu.usa.reto4.repositories.jpa.ReservationJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {
    @Autowired
    private ReservationJpaRepository reservationJpaRepository;

    public void create(Reservation reservation) {
        reservationJpaRepository.save(reservation);
    }

    public List<Reservation> getAll() {
        return reservationJpaRepository.findAll();
    }

    public Reservation findById(Long id) {
        Optional<Reservation> reservation = Optional.of(reservationJpaRepository.getById(id));
        return reservation.orElse(new Reservation());
    }

    public void remove(Long id) {
        reservationJpaRepository.deleteById(id);
    }

    public void update(Reservation reservation) {
        reservationJpaRepository.saveAndFlush(reservation);
    }
}
