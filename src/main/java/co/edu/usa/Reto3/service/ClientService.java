package co.edu.usa.Reto3.service;

import co.edu.usa.Reto3.model.Category;
import co.edu.usa.Reto3.model.Client;

import co.edu.usa.Reto3.model.Message;
import co.edu.usa.Reto3.model.Reservation;
import co.edu.usa.Reto3.repository.ClientRepository;
import co.edu.usa.Reto3.repository.MessageRepository;
import co.edu.usa.Reto3.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class ClientService {
    private final ClientRepository clientRepository;
    private final MessageRepository messageRepository;
    private final ReservationRepository reservationRepository;


    public ClientService(ClientRepository clientRepository, MessageRepository messageRepository, ReservationRepository reservationRepository) {
        this.clientRepository = clientRepository;
        this.messageRepository = messageRepository;
        this.reservationRepository = reservationRepository;
    }

    public Client create(Client client) {
        return clientRepository.save(client);
    }

    public List<Map<String, Object>> getAll() {
        List<Map<String, Object>> list = new ArrayList<>();

        for (Client client : clientRepository.findAll()) {
            Map<String, Object> c = new LinkedHashMap<>();

            c.put("idClient", client.getIdClient());
            c.put("email", client.getEmail());
            c.put("password", client.getPassword());
            c.put("name", client.getName());
            c.put("age", client.getAge());

            List<Map<String, Object>> messages = new ArrayList<>();
            for (Message message : messageRepository.findAll()) {
                Map<String, Object> m = new LinkedHashMap<>();
                if (message.getClient().getIdClient().equals(client.getIdClient())) {
                    m.put("idMessage", message.getIdMessage());
                    m.put("messageText", message.getMessageText());
                    messages.add(m);
                }
            }

            c.put("messages", messages);

            List<Map<String, Object>> reservations = new ArrayList<>();
            for (Reservation reservation : reservationRepository.findAll()) {
                Map<String, Object> r = new LinkedHashMap<>();
                if (reservation.getClient().getIdClient().equals(client.getIdClient())) {
                    r.put("idReservation", reservation.getIdReservation());
                    r.put("startDate", reservation.getStartDate());
                    r.put("devolutionDate", reservation.getDevolutionDate());
                    reservations.add(r);
                }
            }

            c.put("reservations", reservations);

            list.add(c);
        }

        return list;
    }

    public Client findById(Long id) {
        Optional<Client> client = Optional.of(clientRepository.getById(id));
        return client.orElse(new Client());
    }

}
