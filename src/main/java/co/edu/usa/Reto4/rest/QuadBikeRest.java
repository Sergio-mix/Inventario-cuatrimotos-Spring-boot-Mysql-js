package co.edu.usa.Reto4.rest;

import co.edu.usa.Reto4.model.Quadbike;
import co.edu.usa.Reto4.service.QuadBikeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/Quadbike/")
@CrossOrigin
public class QuadBikeRest {

    private final QuadBikeService quadBikeService;

    public QuadBikeRest(QuadBikeService quadBikeService) {
        this.quadBikeService = quadBikeService;
    }

    @GetMapping("all")
    @ResponseStatus(value = HttpStatus.OK)
    private List<Quadbike> listQuadBike() {
        return quadBikeService.getAll();
    }

    @PostMapping(value = "save")
    @ResponseStatus(value = HttpStatus.CREATED)
    private void saveQuadBike(@Valid @RequestBody Quadbike quadBike) throws NumberFormatException {
        quadBikeService.create(quadBike);
    }

    @GetMapping("{id}")
    @ResponseStatus(value = HttpStatus.OK)
    private Quadbike idQuadbike(@PathVariable("id") Long id) {
        return quadBikeService.findById(id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(value = HttpStatus.OK)
    private void removeQuadbike(@PathVariable("id") Long id) {
        quadBikeService.remove(id);
    }

    @PutMapping(value = "update")
    @ResponseStatus(value = HttpStatus.OK)
    private void updateQuadbike(@RequestBody Quadbike quadbike) {
        quadBikeService.update(quadbike);
    }
}
