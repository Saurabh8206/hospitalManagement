package com.hosptial.management.hospitalManagement.Model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Builder
@Table(name = "STAFF_TBL")
public class HospitalStaff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STAFFID")
    private Long id;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "TOKEN")
    private String token;

    @Column(name = "TOKEN_EXPIRY")
    private LocalDateTime tokenExpiration;
}
