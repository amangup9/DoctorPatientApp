package com.medical.connect.service;

import com.medical.connect.dto.DoctorDto;
import com.medical.connect.entity.Doctor;
import com.medical.connect.exception.ResourceNotFoundException;
import com.medical.connect.mapper.DoctorMapper;
import com.medical.connect.repository.DoctorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medical.connect.util.Speciality;

import static com.medical.connect.util.Constants.Exception.INVALID_DOCTOR;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Transactional
    public DoctorDto saveDoctor(DoctorDto doctorDto) {
        Doctor doctor = new Doctor();
        doctor.setName(doctorDto.getName());
        doctor.setCity(doctorDto.getCity().toUpperCase());
        doctor.setEmail(doctorDto.getEmail());
        doctor.setPhone(doctorDto.getPhone());
        doctor.setSpeciality(Speciality.valueOf(doctorDto.getSpeciality().toUpperCase()));
        return DoctorMapper.toDTO(doctorRepository.save(doctor));
    }

    @Transactional
    public void deleteById(int id) {
        if(doctorRepository.existsById(id)) {
            doctorRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException(INVALID_DOCTOR);
        }
    }
}
