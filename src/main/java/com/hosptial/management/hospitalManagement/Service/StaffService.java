package com.hosptial.management.hospitalManagement.Service;

import com.hosptial.management.hospitalManagement.Exception.UnauthorizedException;
import com.hosptial.management.hospitalManagement.Model.HospitalStaff;
import com.hosptial.management.hospitalManagement.Model.LoginDTO;

import java.util.List;
import java.util.Optional;

public interface StaffService {
    void signup(LoginDTO staff);

    String login(String username, String password) throws UnauthorizedException;

    void validateToken(String token) throws UnauthorizedException;

    List<HospitalStaff> getAllStaff();

    Optional<HospitalStaff> fetchStaffById(Long staffId);
}

