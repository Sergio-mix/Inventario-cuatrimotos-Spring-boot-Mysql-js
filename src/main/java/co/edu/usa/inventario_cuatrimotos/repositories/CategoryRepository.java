package co.edu.usa.inventario_cuatrimotos.repositories;

import co.edu.usa.inventario_cuatrimotos.model.Category;
import co.edu.usa.inventario_cuatrimotos.repositories.jpa.CategoryJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoryRepository {
    @Autowired
    private CategoryJpaRepository categoryJpaRepository;

    public Category create(Category category) {
        return categoryJpaRepository.save(category);
    }

    public List<Category> getAll() {
        return categoryJpaRepository.findAll();
    }

    public Category findById(Long id) {
        Optional<Category> category = Optional.of(categoryJpaRepository.getById(id));
        return category.orElse(new Category());
    }

    public void remove(Long id) {
        categoryJpaRepository.deleteById(id);
    }

    public void update(Category category) {
        categoryJpaRepository.saveAndFlush(category);
    }

}
