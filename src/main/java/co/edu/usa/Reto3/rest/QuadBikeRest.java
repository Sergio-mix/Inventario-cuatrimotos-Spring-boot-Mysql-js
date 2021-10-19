package co.edu.usa.Reto3.rest;

import co.edu.usa.Reto3.model.Quadbike;
import co.edu.usa.Reto3.service.QuadBikeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Quadbike/")
public class QuadBikeRest {

    private final QuadBikeService quadBikeService;

    public QuadBikeRest(QuadBikeService quadBikeService) {
        this.quadBikeService = quadBikeService;
    }

    @GetMapping("all")
    @ResponseStatus(HttpStatus.OK)
    private List<Quadbike> listQuadBike() {
        return quadBikeService.getAll();
    }

    @PostMapping(value = "save")
    @ResponseStatus(HttpStatus.CREATED)
    private void saveQuadBike(@RequestBody Quadbike quadBike) throws NumberFormatException {
        quadBikeService.create(quadBike);
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    private Quadbike idQuadbike(@PathVariable("id") Long id) {
        return quadBikeService.findById(id);
    }
}
