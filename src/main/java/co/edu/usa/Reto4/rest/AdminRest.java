package co.edu.usa.Reto4.rest;

import co.edu.usa.Reto4.model.Admin;
import co.edu.usa.Reto4.service.AdminService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/Admin/")
@CrossOrigin
public class AdminRest {
    private final AdminService adminService;

    public AdminRest(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("all")
    @ResponseStatus(value = HttpStatus.OK)
    private List<Admin> listAdmin() {
        return adminService.getAll();
    }

    @PostMapping(value = "save")
    @ResponseStatus(value = HttpStatus.CREATED)
    private void saveAdmin(@Valid @RequestBody Admin admin) {
        adminService.create(admin);
    }

    @GetMapping("{id}")
    @ResponseStatus(value = HttpStatus.OK)
    private Admin idAdmin(@PathVariable("id") Long id) {
        return adminService.findById(id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    private void removeAdmin(@PathVariable("id") Long id) {
        adminService.remove(id);
    }

    @PutMapping(value = "update")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    private void updateAdmin(@RequestBody Admin admin) {
        adminService.update(admin);
    }


}
