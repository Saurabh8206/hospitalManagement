package com.hosptial.management.hospitalManagement.Controller;

import com.hosptial.management.hospitalManagement.Model.Patient;
import com.hosptial.management.hospitalManagement.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @PostMapping("/admit")
    public ResponseEntity<String> admitPatient(@RequestBody Patient patient) {
        patientService.admitPatient(patient);
        return ResponseEntity.ok("Patient admitted successfully");
    }

    @GetMapping
    public ResponseEntity<List<Patient>> getAllAdmittedPatients() {
        List<Patient> patients = patientService.getAllPatients();
        return ResponseEntity.ok(patients);
    }


    @GetMapping("/status/{status}")
    public ResponseEntity<List<Patient>> getAllPatientsByStatus(@PathVariable("status") String status) {
        List<Patient> patients = patientService.getAllPatientsByStatus(status);
        return ResponseEntity.ok(patients);
    }
    @PutMapping("/discharge/{patientId}")
    public ResponseEntity<String> dischargePatient(@PathVariable Long patientId) {
        patientService.dischargePatient(patientId);
        return ResponseEntity.ok("Patient discharged successfully");
    }
}

