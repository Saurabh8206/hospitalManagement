package com.hosptial.management.hospitalManagement.serviceImpl;

import com.hosptial.management.hospitalManagement.Constants.Status;
import com.hosptial.management.hospitalManagement.Exception.ResourceNotFoundException;
import com.hosptial.management.hospitalManagement.Model.Patient;
import com.hosptial.management.hospitalManagement.Repository.PatientRepository;
import com.hosptial.management.hospitalManagement.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientRepository patientRepository;

    @Override
    public void admitPatient(Patient patient) {
        patient.setStatus(Status.ADMITTED.name());
        patientRepository.save(patient);
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public void dischargePatient(Long patientId) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found with id: " + patientId));

        patient.setStatus(Status.DISCHARGED.name());
        patientRepository.save(patient);
    }

    @Override
    public List<Patient> getAllPatientsByStatus(String status) {
        return patientRepository.findByStatus(status);
    }
}

