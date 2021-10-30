package co.edu.usa.inventario_cuatrimotos.service;

import co.edu.usa.inventario_cuatrimotos.model.Category;
import co.edu.usa.inventario_cuatrimotos.repositories.CategoryRepository;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;


    public Category create(Category category) {
        return categoryRepository.create(category);
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
        categoryRepository.update(category);
    }
}
