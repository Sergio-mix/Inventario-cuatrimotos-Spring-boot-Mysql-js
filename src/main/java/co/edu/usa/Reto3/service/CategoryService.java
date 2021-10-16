package co.edu.usa.Reto3.service;

import co.edu.usa.Reto3.model.Admin;
import co.edu.usa.Reto3.model.Category;
import co.edu.usa.Reto3.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    public Category create(Category category) {
        return categoryRepository.save(category);
    }

    public List<Map<String, Object>> getAll() {
        List<Map<String, Object>> list = new ArrayList<>();
        for (Category category : categoryRepository.findAll()) {
            Map<String, Object> c = new LinkedHashMap<>();
            c.put("id", category.getId());
            c.put("name", category.getName());
            c.put("description", category.getDescription());
            c.put("quadbikes", category.getQuadbikes());

            list.add(c);
        }

        return list;
    }

    public Category findById(Long id) {
        Optional<Category> category = Optional.of(categoryRepository.getById(id));
        return category.orElse(new Category());
    }
}
