package co.edu.usa.inventario_cuatrimotos.repositories;

import co.edu.usa.inventario_cuatrimotos.model.Reservation;
import co.edu.usa.inventario_cuatrimotos.repositories.jpa.ReservationJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
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

    public List<Reservation> findAllByStatus(String status) {
        return reservationJpaRepository.findAllByStatus(status);
    }

    public List<Reservation> findAllByStartDate(Date date1, Date date2) {
        return reservationJpaRepository.findAllByStartDateAfterAndStartDateBefore(date1, date2);
    }

    public List<Object[]> countTotalReservationsByClient() {
        return reservationJpaRepository.countTotalReservationsByClient();
    }
}
