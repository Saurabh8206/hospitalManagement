package com.hosptial.management.hospitalManagement.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Builder
@Table(name = "PATIENT_TBL")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "P_ID")
    private Long id;
    @Column(name = "P_NAME")
    private String name;
    @Column(name = "P_AGE")
    private int age;
    @Column(name = "P_ROOM")
    private String room;
    @Column(name = "DOC_NAME")
    private String doctorName;
    @Column(name = "ADMIT_DATE")
    private Date admitDate;
    @Column(name = "EXPENSE")
    private double expenses;
    @Column(name = "STATUS")
    private String status;
}
