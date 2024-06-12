package com.medical.connect.service;

import com.medical.connect.dto.DoctorDto;
import com.medical.connect.entity.Doctor;
import com.medical.connect.entity.Patient;
import com.medical.connect.exception.ResourceNotFoundException;
import com.medical.connect.mapper.DoctorMapper;
import com.medical.connect.repository.DoctorRepository;
import com.medical.connect.repository.PatientRepository;
import com.medical.connect.util.Speciality;
import com.medical.connect.util.Symptom;
import com.medical.connect.util.SymptomSpecialityMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.medical.connect.util.Constants.Exception.*;


@Service
public class QueryService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;

    public Page<DoctorDto> getDoctors(Integer patientId, Pageable pageable) {
        Page<Doctor> doctorList = new PageImpl<>(new ArrayList<>());
        Optional<Patient> patient = patientRepository.findById(patientId);
        if (patient.isEmpty()) {
            throw new ResourceNotFoundException(INVALID_PATIENT);
        }
        String city = patient.get().getCity().toUpperCase();
        Symptom symptom = patient.get().getSymptom();
        Speciality speciality = SymptomSpecialityMap.SYMPTOM_SPECIALITY_HASH_MAP.get(symptom);

        if (speciality != null) {
            doctorList = doctorRepository.findAllByCity(city,pageable);
        } else {
            throw new NullPointerException(NOT_KNOWN_SPECIALITY);
        }
        if (!doctorList.hasContent()) {
            throw new ResourceNotFoundException(DOCTOR_NOT_EXIST);
        }
        List<Doctor> filteredDoctors = doctorList.stream()
                .filter(doctor -> doctor.getSpeciality().name().equalsIgnoreCase(speciality.name()))
                .toList();
        if (filteredDoctors.isEmpty()) {
            throw new ResourceNotFoundException(DOCTOR_WITH_SYMPTOM_NOT_EXIST);
        }
        List<DoctorDto> doctorsOnPage = filteredDoctors.stream().map(DoctorMapper::toDTO).toList();
        return new PageImpl<>(doctorsOnPage, PageRequest.of(pageable.getPageNumber(), pageable.getPageSize()),
                doctorList.getTotalElements());
    }
}
