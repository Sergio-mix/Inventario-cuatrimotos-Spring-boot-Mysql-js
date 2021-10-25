package co.edu.usa.Reto4.service;

import co.edu.usa.Reto4.model.Reservation;
import co.edu.usa.Reto4.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    public void create(Reservation reservation) {
        reservation.setStartDate(reservation.getStartDate() + "T00:00:00.000+00:00");
        reservation.setDevolutionDate(reservation.getDevolutionDate() + "T00:00:00.000+00:00");
        reservation.setStatus("created");
        reservationRepository.create(reservation);
    }

    public List<Reservation> getAll() {
        return reservationRepository.getAll();
    }

    public Reservation findById(Long id) {
        return reservationRepository.findById(id);
    }

    public void remove(Long id) {
        reservationRepository.remove(id);
    }

    public void update(Reservation reservation) {
        reservationRepository.update(reservation);
    }

}
