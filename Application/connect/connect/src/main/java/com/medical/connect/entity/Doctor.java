package com.medical.connect.entity;

import com.medical.connect.util.Speciality;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "doctor")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name= "name", nullable = false)
    private String name;

    @Column(name= "city", nullable = false)
    private String city;

    @Column(name= "email")
    private String email;

    @Column(name= "phone", nullable = false)
    private String phone;

    @Enumerated(EnumType.STRING)
    @Column(name= "speciality", nullable = false)
    private Speciality speciality;
}
