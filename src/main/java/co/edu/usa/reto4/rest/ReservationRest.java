package co.edu.usa.reto4.rest;

import co.edu.usa.reto4.model.Reservation;
import co.edu.usa.reto4.service.ReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/Reservation/")
//@CrossOrigin
public class ReservationRest {

    private final ReservationService reservationService;

    public ReservationRest(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("all")
    @ResponseStatus(value = HttpStatus.OK)
    private List<Reservation> listReservation() {
        return reservationService.getAll();
    }

    @PostMapping(value = "save")
    @ResponseStatus(value = HttpStatus.CREATED)
    private void saveReservation(@Valid @RequestBody Reservation reservation) {
        reservationService.create(reservation);
    }

    @GetMapping("{id}")
    @ResponseStatus(value = HttpStatus.OK)
    private Reservation idReservation(@PathVariable("id") Long id) {
        return reservationService.findById(id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    private void removeReservation(@PathVariable("id") Long id) {
        reservationService.remove(id);
    }

    @PutMapping(value = "update")
    @ResponseStatus(value = HttpStatus.CREATED)
    private void updateReservation(@Valid @RequestBody Reservation reservation) {
        reservationService.update(reservation);
    }
}
