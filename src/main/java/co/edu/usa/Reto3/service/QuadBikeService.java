package co.edu.usa.Reto3.service;

import co.edu.usa.Reto3.model.Category;
import co.edu.usa.Reto3.model.Message;
import co.edu.usa.Reto3.model.Quadbike;
import co.edu.usa.Reto3.model.Reservation;
import co.edu.usa.Reto3.repository.MessageRepository;
import co.edu.usa.Reto3.repository.QuadBikeRepository;
import co.edu.usa.Reto3.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class QuadBikeService {
    private final QuadBikeRepository quadBikeRepository;
    private final MessageRepository messageRepository;
    private final ReservationRepository reservationRepository;


    public QuadBikeService(QuadBikeRepository quadBikeRepository, MessageRepository messageRepository, ReservationRepository reservationRepository) {
        this.quadBikeRepository = quadBikeRepository;
        this.messageRepository = messageRepository;
        this.reservationRepository = reservationRepository;
    }

    public Quadbike create(Quadbike quadBike) {
        return quadBikeRepository.save(quadBike);
    }

    public List<Map<String, Object>> getAll() {
        List<Map<String, Object>> list = new ArrayList<>();

        for (Quadbike quadbike : quadBikeRepository.findAll()) {
            Map<String, Object> map = new LinkedHashMap<>();
            map.put("id", quadbike.getId());
            map.put("name", quadbike.getName());
            map.put("brand", quadbike.getBrand());
            map.put("year", quadbike.getYear());
            map.put("description", quadbike.getDescription());

            Map<String, Object> category = new LinkedHashMap<>();
            category.put("id", quadbike.getCategory().getId());
            category.put("name", quadbike.getCategory().getName());
            category.put("description", quadbike.getCategory().getDescription());

            map.put("category", category);

            List<Map<String, Object>> messages = new ArrayList<>();
            for (Message message : messageRepository.findAll()) {
                Map<String, Object> m = new LinkedHashMap<>();
                if (message.getQuadbike().getId().equals(quadbike.getId())) {
                    m.put("idMessage", message.getIdMessage());
                    m.put("messageText", message.getMessageText());
                    messages.add(m);
                }
            }

            map.put("messages", messages);

            List<Map<String, Object>> reservations = new ArrayList<>();
            for (Reservation reservation : reservationRepository.findAll()) {
                Map<String, Object> r = new LinkedHashMap<>();
                if (reservation.getQuadbike().getId().equals(quadbike.getId())) {
                    r.put("idReservation", reservation.getIdReservation());
                    r.put("startDate", reservation.getStartDate());
                    r.put("devolutionDate", reservation.getDevolutionDate());
                    reservations.add(r);
                }
            }

            map.put("reservations", reservations);

            list.add(map);
        }

        return list;
    }

    public Quadbike findById(Long id) {
        Optional<Quadbike> quadbike = Optional.of(quadBikeRepository.getById(id));
        return quadbike.orElse(new Quadbike());
    }

}

