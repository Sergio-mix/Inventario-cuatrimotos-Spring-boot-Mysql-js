package co.edu.usa.reto4.rest;

import co.edu.usa.reto4.model.Category;
import co.edu.usa.reto4.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/Category/")
@CrossOrigin
public class CategoryRest {

    private final CategoryService categoryService;

    public CategoryRest(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping("all")
    @ResponseStatus(value = HttpStatus.OK)
    private List<Category> listCategory() {
        return categoryService.getAll();
    }

    @PostMapping(value = "save")
    @ResponseStatus(HttpStatus.CREATED)
    private void saveCategory(@RequestBody Category category) {
        categoryService.create(category);
    }

    @GetMapping("{id}")
    @ResponseStatus(value = HttpStatus.OK)
    private Category idCategory(@PathVariable("id") Long id) {
        return categoryService.findById(id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    private void removeCategory(@PathVariable("id") Long id) {
        categoryService.remove(id);
    }

    @PutMapping(value = "update")
    @ResponseStatus(value = HttpStatus.CREATED)
    private void updateCategory(@RequestBody Category category) {
        categoryService.update(category);
    }

    @GetMapping("name/{name}")
    @ResponseStatus(value = HttpStatus.OK)
    private Map<String, Object> validationName(@PathVariable("name") String name) {
        return categoryService.validationName(name);
    }
}
