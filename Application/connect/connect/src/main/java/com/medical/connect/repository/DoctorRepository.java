package com.medical.connect.repository;

import com.medical.connect.entity.Doctor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
    Page<Doctor> findAllByCity(String city, Pageable pageable);
}
