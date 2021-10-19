package co.edu.usa.Reto3.service;

import co.edu.usa.Reto3.model.Reservation;
import co.edu.usa.Reto3.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;



    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public void create(Reservation reservation) {
        reservation.setStartDate(reservation.getStartDate() + "T00:00:00.000+00:00");
        reservation.setDevolutionDate(reservation.getDevolutionDate() + "T00:00:00.000+00:00");
        reservation.setStatus("created");
        reservationRepository.save(reservation);
    }

    public List<Reservation> getAll() {
        return reservationRepository.findAll();
    }

    public Reservation findById(Long id) {
        Optional<Reservation> reservation = Optional.of(reservationRepository.getById(id));
        return reservation.orElse(new Reservation());
    }

}
