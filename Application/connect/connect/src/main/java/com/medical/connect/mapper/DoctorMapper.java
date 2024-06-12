package com.medical.connect.mapper;


import com.medical.connect.dto.DoctorDto;
import com.medical.connect.entity.Doctor;
import com.medical.connect.util.Speciality;

public class DoctorMapper {
    public static DoctorDto toDTO(Doctor doctor) {
        return new DoctorDto(doctor.getId(), doctor.getName(),
                doctor.getCity(), doctor.getEmail(), doctor.getPhone(), doctor.getSpeciality().name());
    }

    public static Doctor fromDto(DoctorDto doctorDto) {
        return new Doctor(doctorDto.getId(), doctorDto.getName(),
                doctorDto.getCity(), doctorDto.getEmail(), doctorDto.getPhone(), Speciality.valueOf(doctorDto.getSpeciality()));
    }
}
