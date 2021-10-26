package co.edu.usa.reto4.repositories;

import co.edu.usa.reto4.model.Quadbike;
import co.edu.usa.reto4.repositories.jpa.QuadBikeJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class QuadBikeRepository {
    @Autowired
    private QuadBikeJpaRepository quadBikeJpaRepository;

    public Quadbike create(Quadbike quadBike) {
        return quadBikeJpaRepository.save(quadBike);
    }

    public List<Quadbike> getAll() {
        return quadBikeJpaRepository.findAll();
    }

    public Quadbike findById(Long id) {
        Optional<Quadbike> quadbike = Optional.of(quadBikeJpaRepository.getById(id));
        return quadbike.orElse(new Quadbike());
    }

    public void remove(Long id) {
        quadBikeJpaRepository.deleteById(id);
    }

    public void update(Quadbike quadbike) {
        if (quadbike.getCategory() == null) {
            quadbike.setCategory(quadBikeJpaRepository.getById(quadbike.getId()).getCategory());
        }
        quadBikeJpaRepository.saveAndFlush(quadbike);
    }
}
