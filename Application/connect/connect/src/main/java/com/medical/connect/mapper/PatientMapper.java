package com.medical.connect.mapper;


import com.medical.connect.dto.PatientDto;
import com.medical.connect.entity.Patient;
import com.medical.connect.util.Symptom;

public class PatientMapper {
    public static PatientDto toDTO(Patient patient) {
        return new PatientDto(patient.getId(), patient.getName(),
                patient.getCity(), patient.getEmail(), patient.getPhone(), patient.getSymptom().name());
    }
    
    public static Patient fromDto(PatientDto patientDto) {
        return new Patient(patientDto.getId(), patientDto.getName(),         
                patientDto.getCity(), patientDto.getEmail(), patientDto.getPhone(), Symptom.valueOf(patientDto.getSymptom()));
    }
}
