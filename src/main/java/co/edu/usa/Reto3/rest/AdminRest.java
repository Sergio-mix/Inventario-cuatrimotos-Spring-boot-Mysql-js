package co.edu.usa.Reto3.rest;

import co.edu.usa.Reto3.model.Admin;
import co.edu.usa.Reto3.service.AdminService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Admin/")
public class AdminRest {
    private final AdminService adminService;

    public AdminRest(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("all")
    @ResponseStatus(HttpStatus.OK)
    private List<Admin> listAdmin() {
        return adminService.getAll();
    }

    @PostMapping(value = "save")
    @ResponseStatus(HttpStatus.CREATED)
    private void saveAdmin(@RequestBody Admin admin) {
        adminService.create(admin);
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    private Admin idAdmin(@PathVariable("id") Long id) {
        return adminService.findById(id);
    }
}
