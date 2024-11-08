package com.employee.AdminController;

import com.employee.AdminDao.AdminDao;
import com.employee.AdminModel.Admin;
import com.employee.AdminService.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@CrossOrigin("*")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private AdminDao adminDao;


    @PostMapping("/")
    public ResponseEntity<Admin> createPage(@RequestBody Admin admin)
    {
        Admin page = this.adminService.createPage(admin);

        return new ResponseEntity<>(page, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Admin adminData)
    {
        Admin admin = this.adminDao.findByEmail(adminData.getEmail());


        if (admin.getConfirmPassword().equals(adminData.getConfirmPassword()))
            return ResponseEntity.ok(admin);


        return new ResponseEntity<>(admin,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
