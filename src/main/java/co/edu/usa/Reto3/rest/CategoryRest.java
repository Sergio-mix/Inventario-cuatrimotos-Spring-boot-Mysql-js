package co.edu.usa.Reto3.rest;

import co.edu.usa.Reto3.model.Category;
import co.edu.usa.Reto3.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/Category/")
public class CategoryRest {

    private final CategoryService categoryService;

    public CategoryRest(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("all")
    @ResponseStatus(HttpStatus.OK)
    private List<Map<String, Object>> listCategory() {
        return categoryService.getAll();
    }

    @PostMapping(value = "save")
    @ResponseStatus(HttpStatus.CREATED)
    private void saveCategory(@RequestBody Category category) {
        categoryService.create(category);
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    private Category idCategory(@PathVariable("id") Long id) {
        return categoryService.findById(id);
    }
}
