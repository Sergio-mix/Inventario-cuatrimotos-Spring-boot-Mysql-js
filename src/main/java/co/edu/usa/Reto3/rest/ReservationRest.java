package co.edu.usa.Reto3.rest;

import co.edu.usa.Reto3.model.Reservation;
import co.edu.usa.Reto3.service.ReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Reservation/")
public class ReservationRest {

    private final ReservationService reservationService;

    public ReservationRest(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("all")
    @ResponseStatus(HttpStatus.OK)
    private List<Reservation> listReservation() {
        return reservationService.getAll();
    }

    @PostMapping(value = "save")
    @ResponseStatus(HttpStatus.CREATED)
    private void saveReservation(@RequestBody Reservation reservation) {
        reservationService.create(reservation);
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    private Reservation idReservation(@PathVariable("id") Long id) {
        return reservationService.findById(id);
    }
}
