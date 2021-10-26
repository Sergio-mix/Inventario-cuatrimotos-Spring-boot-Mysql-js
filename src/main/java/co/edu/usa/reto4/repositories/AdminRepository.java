package co.edu.usa.reto4.repositories;

import co.edu.usa.reto4.model.Admin;
import co.edu.usa.reto4.repositories.jpa.AdminJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AdminRepository {

    @Autowired
    private AdminJpaRepository adminJpaRepository;

    public Admin create(Admin admin) {
        return adminJpaRepository.save(admin);
    }

    public List<Admin> getAll() {
        return adminJpaRepository.findAll();
    }

    public Admin findById(Long id) {
        Optional<Admin> admin = Optional.of(adminJpaRepository.getById(id));
        return admin.orElse(new Admin());
    }

    public void remove(Long id) {
        adminJpaRepository.deleteById(id);
    }

    public void update(Admin admin) {
        adminJpaRepository.saveAndFlush(admin);
    }
}
