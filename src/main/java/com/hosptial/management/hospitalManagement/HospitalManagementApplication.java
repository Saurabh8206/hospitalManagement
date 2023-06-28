package com.hosptial.management.hospitalManagement;

import com.hosptial.management.hospitalManagement.Constants.Status;
import com.hosptial.management.hospitalManagement.Model.HospitalStaff;
import com.hosptial.management.hospitalManagement.Model.Patient;
import com.hosptial.management.hospitalManagement.Repository.PatientRepository;
import com.hosptial.management.hospitalManagement.Repository.StaffRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class HospitalManagementApplication {

    @Autowired
    private final StaffRepository staffRepository;
    private final PatientRepository patientRepository;

    public HospitalManagementApplication(StaffRepository staffRepository, PatientRepository patientRepository) {
        this.staffRepository = staffRepository;
        this.patientRepository = patientRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(HospitalManagementApplication.class, args);
    }


    @PostConstruct
    public void initializeSampleData() {

        HospitalStaff staff1 = HospitalStaff.builder().username("user1").password("Password@123").token(UUID.randomUUID().toString()).tokenExpiration(LocalDateTime.now()).build();
        HospitalStaff staff2 = HospitalStaff.builder().username("user2").password("Password@123").token(UUID.randomUUID().toString()).tokenExpiration(LocalDateTime.now()).build();
        HospitalStaff staff3 = HospitalStaff.builder().username("user3").password("Password@123").token(UUID.randomUUID().toString()).tokenExpiration(LocalDateTime.now()).build();


        Patient patient1 = Patient.builder().name("pName").age(23).admitDate(new Date())
                .doctorName("Dr.Doc").room("1244").expenses(2333.43).status(Status.ADMITTED.name()).build();

        Patient patient2 = Patient.builder().name("Name").age(23).admitDate(new Date())
                .doctorName("Dr.Doc").room("1245").expenses(3333.43).status(Status.DISCHARGED.name()).build();

        patientRepository.saveAll(List.of(patient1, patient2));
        staffRepository.saveAll(List.of(staff1, staff2, staff3));
        System.out.println("Sample data saved successfully!");
    }
}
