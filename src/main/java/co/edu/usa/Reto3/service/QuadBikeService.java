package co.edu.usa.Reto3.service;

import co.edu.usa.Reto3.model.Quadbike;
import co.edu.usa.Reto3.repository.MessageRepository;
import co.edu.usa.Reto3.repository.QuadBikeRepository;
import co.edu.usa.Reto3.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class QuadBikeService {
    private final QuadBikeRepository quadBikeRepository;

    public QuadBikeService(QuadBikeRepository quadBikeRepository) {
        this.quadBikeRepository = quadBikeRepository;
    }

    public Quadbike create(Quadbike quadBike) {
        return quadBikeRepository.save(quadBike);
    }

    public List<Quadbike> getAll() {
     return quadBikeRepository.findAll();
    }

    public Quadbike findById(Long id) {
        Optional<Quadbike> quadbike = Optional.of(quadBikeRepository.getById(id));
        return quadbike.orElse(new Quadbike());
    }

}

