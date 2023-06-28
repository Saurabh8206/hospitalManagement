package com.hosptial.management.hospitalManagement.Repository;

import com.hosptial.management.hospitalManagement.Model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findByStatus(String admitted);
}
