package co.edu.usa.inventario_cuatrimotos.service;

import co.edu.usa.inventario_cuatrimotos.model.Reservation;
import co.edu.usa.inventario_cuatrimotos.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    public void create(Reservation reservation) {
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

    public List<Reservation> findAllByStartDate(String date1, String date2) {
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
        Date dato1 = new Date();
        Date dato2 = new Date();

        try {
            dato1 = parser.parse(date1);
            dato2 = parser.parse(date2);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (dato1.before(dato2)) {
            return reservationRepository.findAllByStartDate(dato1, dato2);
        } else {
            return new ArrayList<>();
        }
    }

    public Map<String, Object> reservacionStatus() {
        Map<String, Object> statusList = new LinkedHashMap<>();

        List<Reservation> completed = reservationRepository.findAllByStatus("completed");
        List<Reservation> cancelled = reservationRepository.findAllByStatus("cancelled");

        statusList.put("completed", completed.size());
        statusList.put("cancelled", cancelled.size());

        return statusList;
    }

    public List<Map<String, Object>> countTotalReservationsByClient() {

        List<Map<String, Object>> list = new ArrayList<>();

        List<Object[]> report = reservationRepository.countTotalReservationsByClient();

        for (Object[] objects : report) {
            Map<String, Object> map = new LinkedHashMap<>();
            map.put("total", objects[1]);
            map.put("client", objects[0]);
            list.add(map);
        }

        return list;
    }

}
