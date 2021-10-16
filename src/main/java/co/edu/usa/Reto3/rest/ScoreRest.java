package co.edu.usa.Reto3.rest;

import co.edu.usa.Reto3.model.Score;
import co.edu.usa.Reto3.service.ScoreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Score/")
public class ScoreRest {
    private final ScoreService scoreService;

    public ScoreRest(ScoreService scoreService) {
        this.scoreService = scoreService;
    }

    @GetMapping("all")
    @ResponseStatus(HttpStatus.OK)
    private List<Score> listScore() {
        return scoreService.getAll();
    }

    @PostMapping(value = "save")
    @ResponseStatus(HttpStatus.CREATED)
    private void saveScore(@RequestBody Score score) {
        scoreService.create(score);
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    private Score idScore(@PathVariable("id") Long id) {
        return scoreService.findById(id);
    }
}
