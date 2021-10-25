package co.edu.usa.Reto4.service;

import co.edu.usa.Reto4.model.Category;
import co.edu.usa.Reto4.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;


    public Category create(Category category) {
        Map<String, Object> a = validationName(category.getName());
        if (!((boolean) a.get("validation"))) {
            return categoryRepository.create(category);
        }
        return null;
    }

    public List<Category> getAll() {
        return categoryRepository.getAll();
    }

    public Category findById(Long id) {
        return categoryRepository.findById(id);
    }

    public void remove(Long id) {
        categoryRepository.remove(id);
    }

    public void update(Category category) {
        if (!category.getName().equals(findById(category.getId()).getName())) {
            Map<String, Object> a = validationName(category.getName());
            if (!((boolean) a.get("validation"))) {
                categoryRepository.update(category);
            }
        } else {
            categoryRepository.update(category);
        }
    }

    public Map<String, Object> validationName(String name) {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("validation", false);

        for (Category category : getAll()) {
            if (category.getName().equals(name)) {
                map.put("validation", true);
                return map;
            }
        }
        return map;
    }
}
