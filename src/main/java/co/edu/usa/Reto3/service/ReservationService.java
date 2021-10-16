package co.edu.usa.Reto3.service;

import co.edu.usa.Reto3.model.Category;
import co.edu.usa.Reto3.model.Message;
import co.edu.usa.Reto3.model.Reservation;
import co.edu.usa.Reto3.model.Score;
import co.edu.usa.Reto3.repository.MessageRepository;
import co.edu.usa.Reto3.repository.ReservationRepository;
import co.edu.usa.Reto3.repository.ScoreRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final MessageRepository messageRepository;
    private final ScoreRepository scoreRepository;


    public ReservationService(ReservationRepository reservationRepository, MessageRepository messageRepository, ScoreRepository scoreRepository) {
        this.reservationRepository = reservationRepository;
        this.messageRepository = messageRepository;
        this.scoreRepository = scoreRepository;
    }

    public void create(Reservation reservation) {
        reservation.setStartDate(reservation.getStartDate() + "T00:00:00.000+00:00");
        reservation.setDevolutionDate(reservation.getDevolutionDate() + "T00:00:00.000+00:00");
        reservation.setStatus("created");
        Reservation reservation1 = reservationRepository.save(reservation);
        Score score = new Score();
        score.setReservation(reservation1);
        Score s = scoreRepository.save(score);
        reservation1.setScore(s);
        reservationRepository.save(reservation1);
    }

    public List<Map<String, Object>> getAll() {
        List<Map<String, Object>> list = new ArrayList<>();

        for (Reservation reservation : reservationRepository.findAll()) {
            Map<String, Object> r = new LinkedHashMap<>();
            r.put("idReservation", reservation.getIdReservation());
            r.put("startDate", reservation.getStartDate());
            r.put("devolutionDate", reservation.getDevolutionDate());
            r.put("status", reservation.getStatus());

            Map<String, Object> quadbike = new LinkedHashMap<>();
            quadbike.put("id", reservation.getQuadbike().getId());
            quadbike.put("name", reservation.getQuadbike().getName());
            quadbike.put("brand", reservation.getQuadbike().getBrand());
            quadbike.put("year", reservation.getQuadbike().getYear());
            quadbike.put("description", reservation.getQuadbike().getDescription());

            Map<String, Object> category = new LinkedHashMap<>();
            category.put("id", reservation.getQuadbike().getCategory().getId());
            category.put("name", reservation.getQuadbike().getCategory().getName());
            category.put("description", reservation.getQuadbike().getCategory().getDescription());

            quadbike.put("category", category);

            List<Map<String, Object>> messages = new ArrayList<>();

            for (Message message : messageRepository.findAll()) {
                if (message.getQuadbike().getId().equals(reservation.getQuadbike().getId())
                        && message.getQuadbike().getId().equals(reservation.getQuadbike().getId())) {
                    Map<String, Object> m = new LinkedHashMap<>();
                    m.put("idMessage", message.getIdMessage());
                    m.put("messageText", message.getMessageText());
                    messages.add(m);
                }
            }

            quadbike.put("messages", messages);

            r.put("quadbike", quadbike);

            Map<String, Object> client = new LinkedHashMap<>();
            client.put("idClient", reservation.getClient().getIdClient());
            client.put("email", reservation.getClient().getEmail());
            client.put("password", reservation.getClient().getPassword());
            client.put("name", reservation.getClient().getName());
            client.put("age", reservation.getClient().getAge());

            r.put("client", client);

            r.put("score", reservation.getScore().getQualification());

            list.add(r);
        }

        return list;
    }

    public Reservation findById(Long id) {
        Optional<Reservation> reservation = Optional.of(reservationRepository.getById(id));
        return reservation.orElse(new Reservation());
    }

}
