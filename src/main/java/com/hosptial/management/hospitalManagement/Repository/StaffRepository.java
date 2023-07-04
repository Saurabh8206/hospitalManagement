package com.hosptial.management.hospitalManagement.Repository;

import com.hosptial.management.hospitalManagement.Model.HospitalStaff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends JpaRepository<HospitalStaff, Long> {
    HospitalStaff findByUsernameAndPassword(String username, String password);

    HospitalStaff findByToken(String token);


    boolean existsByUsername(String username);
}
