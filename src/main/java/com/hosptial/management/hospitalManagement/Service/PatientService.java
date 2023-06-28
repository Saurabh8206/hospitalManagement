package com.hosptial.management.hospitalManagement.Service;

import com.hosptial.management.hospitalManagement.Model.Patient;

import java.util.List;

public interface PatientService {
    void admitPatient(Patient patient);

    List<Patient> getAllPatients();

    void dischargePatient(Long patientId);

    List<Patient> getAllPatientsByStatus(String status);
}

