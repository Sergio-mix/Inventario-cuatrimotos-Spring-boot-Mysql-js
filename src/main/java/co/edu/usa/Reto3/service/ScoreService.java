package co.edu.usa.Reto3.service;

import co.edu.usa.Reto3.model.Category;
import co.edu.usa.Reto3.model.Score;
import co.edu.usa.Reto3.repository.ScoreRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreService {
    private final ScoreRepository scoreRepository;

    public ScoreService(ScoreRepository scoreRepository) {
        this.scoreRepository = scoreRepository;
    }

    public Score create(Score score) {
        return scoreRepository.save(score);
    }

    public List<Score> getAll() {
        return scoreRepository.findAll();
    }

    public Score findById(Long id) {
        Optional<Score> score = Optional.of(scoreRepository.getById(id));
        return score.orElse(new Score());
    }
}
