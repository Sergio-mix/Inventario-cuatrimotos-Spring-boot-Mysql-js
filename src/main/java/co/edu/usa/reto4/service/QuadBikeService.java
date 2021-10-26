package co.edu.usa.reto4.service;

import co.edu.usa.reto4.model.Quadbike;
import co.edu.usa.reto4.repositories.QuadBikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuadBikeService {
    @Autowired
    private QuadBikeRepository quadBikeRepository;

    public Quadbike create(Quadbike quadBike) {
        return quadBikeRepository.create(quadBike);
    }

    public List<Quadbike> getAll() {
        return quadBikeRepository.getAll();
    }

    public Quadbike findById(Long id) {
        return quadBikeRepository.findById(id);
    }

    public void remove(Long id) {
        quadBikeRepository.remove(id);
    }

    public void update(Quadbike quadbike) {
        quadBikeRepository.update(quadbike);
    }
}

