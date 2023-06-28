package com.hosptial.management.hospitalManagement.Controller;

import com.hosptial.management.hospitalManagement.Exception.ResourceNotFoundException;
import com.hosptial.management.hospitalManagement.Exception.UnauthorizedException;
import com.hosptial.management.hospitalManagement.Model.HospitalStaff;
import com.hosptial.management.hospitalManagement.Model.LoginDTO;
import com.hosptial.management.hospitalManagement.Service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/staff")
public class StaffController {
    @Autowired
    private StaffService staffService;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody LoginDTO staff) {
        staffService.signup(staff);
        return ResponseEntity.ok("Signup successful!!! Welcome " + staff.getUserName());
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDTO loginForm) throws UnauthorizedException {
        String authToken = staffService.login(loginForm.getUserName(), loginForm.getPassword());
        return ResponseEntity.ok(authToken);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<HospitalStaff>> getAllStaffFroAdmin() {
        List<HospitalStaff> allStaff = staffService.getAllStaff();
        return ResponseEntity.ok(allStaff);
    }


    @GetMapping("/get-staff-by-id/{staffId}")
    public ResponseEntity<HospitalStaff> getStaffById(@PathVariable("staffId") Long staffId) {
        HospitalStaff staff = staffService.fetchStaffById(staffId).
                orElseThrow(() -> new ResourceNotFoundException("Staff not found with id: " + staffId));
        return ResponseEntity.ok(staff);
    }

}
