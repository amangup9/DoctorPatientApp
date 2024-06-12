package com.medical.connect.entity;

import com.medical.connect.util.Symptom;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "patient")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
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

    // Assuming here symptom is single valued
    @Enumerated(EnumType.STRING)
    @Column(name= "symptom")
    private Symptom symptom;
}
