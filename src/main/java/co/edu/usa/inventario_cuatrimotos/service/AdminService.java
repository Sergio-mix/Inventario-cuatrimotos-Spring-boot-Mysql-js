package co.edu.usa.inventario_cuatrimotos.service;

import co.edu.usa.inventario_cuatrimotos.model.Admin;
import co.edu.usa.inventario_cuatrimotos.repositories.AdminRepository;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public Admin create(Admin admin) {
//        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
//        admin.setPassword(argon2.hash(1, 1024, 1, admin.getPassword()));
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

    public void verifyCredentials(String email, String password){

    }

}
