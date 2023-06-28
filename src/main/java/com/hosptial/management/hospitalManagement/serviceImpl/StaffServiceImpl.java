package com.hosptial.management.hospitalManagement.serviceImpl;

import com.hosptial.management.hospitalManagement.Exception.UnauthorizedException;
import com.hosptial.management.hospitalManagement.Model.HospitalStaff;
import com.hosptial.management.hospitalManagement.Model.LoginDTO;
import com.hosptial.management.hospitalManagement.Repository.StaffRepository;
import com.hosptial.management.hospitalManagement.Service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StaffServiceImpl implements StaffService {
    @Autowired
    private StaffRepository staffRepository;

    @Override
    public void signup(LoginDTO staff) {

        HospitalStaff hospitalStaff = HospitalStaff.builder()
                .username(staff.getUserName())
                .password(staff.getPassword())
                .token(UUID.randomUUID().toString())
                .tokenExpiration(LocalDateTime.now()).build();
        staffRepository.save(hospitalStaff);
    }

    @Override
    public String login(String username, String password) throws UnauthorizedException {
        HospitalStaff staff = staffRepository.findByUsernameAndPassword(username, password);
        if (staff != null) {
            // Generate and store the authentication token
            String authToken = generateAuthToken();
            staff.setToken(authToken);
            staff.setTokenExpiration(LocalDateTime.now().plusHours(24));
            staffRepository.save(staff);
            return authToken;
        } else {
            throw new UnauthorizedException("Invalid user! PLease try again with correct data");
        }
    }

    @Override
    public void validateToken(String token) throws UnauthorizedException {
        HospitalStaff staff = staffRepository.findByToken(token);
        if (staff == null || staff.getTokenExpiration().isBefore(LocalDateTime.now())) {
            throw new UnauthorizedException("Invalid or expired token");
        }
    }

    @Override
    public List<HospitalStaff> getAllStaff() {
        return staffRepository.findAll();
    }

    public Optional<HospitalStaff> fetchStaffById(Long staffId) {
        return staffRepository.findById(staffId);
    }

    private String generateAuthToken() {
        // Generate a random UUID token
        return UUID.randomUUID().toString();
    }
}
