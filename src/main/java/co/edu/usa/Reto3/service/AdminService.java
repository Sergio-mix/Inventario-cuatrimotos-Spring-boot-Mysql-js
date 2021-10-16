package co.edu.usa.Reto3.service;

import co.edu.usa.Reto3.model.Admin;
import co.edu.usa.Reto3.repository.AdminRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    private final AdminRepository adminRepository;


    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public Admin create(Admin admin) {
        return adminRepository.save(admin);
    }

    public List<Admin> getAll() {
        return adminRepository.findAll();
    }

    public Admin findById(Long id) {
        Optional<Admin> admin = Optional.of(adminRepository.getById(id));
        return admin.orElse(new Admin());
    }

}
