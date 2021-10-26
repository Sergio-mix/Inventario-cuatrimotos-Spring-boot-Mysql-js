package co.edu.usa.reto4.service;

import co.edu.usa.reto4.model.Admin;
import co.edu.usa.reto4.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AdminService {
    @Autowired
    private  AdminRepository adminRepository;

    public Admin create(Admin admin) {
        return adminRepository.create(admin);
    }

    public List<Admin> getAll() {
        return adminRepository.getAll();
    }

    public Admin findById(Long id) {
        return adminRepository.findById(id);
    }

    public void remove(Long id) {
        adminRepository.remove(id);
    }

    public void update(Admin admin) {
        adminRepository.update(admin);
    }

}
