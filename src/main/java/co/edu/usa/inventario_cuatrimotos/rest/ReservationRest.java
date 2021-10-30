package co.edu.usa.inventario_cuatrimotos.rest;

import co.edu.usa.inventario_cuatrimotos.model.Reservation;
import co.edu.usa.inventario_cuatrimotos.service.ReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/Reservation/")
@CrossOrigin
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

    @GetMapping(value = "report-dates/{date1}/{date2}")
    private List<Reservation> findAllByStartDate(@PathVariable("date1") String date1, @PathVariable("date2") String date2) {
        return reservationService.findAllByStartDate(date1, date2);
    }

    @GetMapping(value = "report-status")
    private Map<String, Object> findAllByStatus() {
        return reservationService.reservacionStatus();
    }

    @GetMapping("report-clients")
    public List<Map<String, Object>> getClientes() {
        return reservationService.countTotalReservationsByClient();
    }


}
