package com.medical.connect.service;

import com.medical.connect.dto.PatientDto;
import com.medical.connect.entity.Patient;
import com.medical.connect.exception.ResourceNotFoundException;
import com.medical.connect.mapper.PatientMapper;
import com.medical.connect.repository.PatientRepository;
import com.medical.connect.util.Symptom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.medical.connect.util.Constants.Exception.INVALID_PATIENT;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public PatientDto savePatient(PatientDto patientDto) {
        Patient patient = new Patient();
        patient.setName(patientDto.getName());
        patient.setCity(patientDto.getCity().toUpperCase());
        patient.setEmail(patientDto.getEmail());
        patient.setPhone(patientDto.getPhone());
        patient.setSymptom(Symptom.valueOf(patientDto.getSymptom().toUpperCase()));
        return PatientMapper.toDTO(patientRepository.save(patient));
    }

    public void deleteById(int id) {
        if(patientRepository.existsById(id)) {
            patientRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException(INVALID_PATIENT);
        }
    }
}
