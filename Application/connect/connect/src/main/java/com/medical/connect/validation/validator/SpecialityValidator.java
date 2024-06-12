package com.medical.connect.validation.validator;

import com.medical.connect.util.Speciality;
import com.medical.connect.validation.ValidSpeciality;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class SpecialityValidator implements ConstraintValidator<ValidSpeciality, String> {

    @Override
    public void initialize(ValidSpeciality constraintAnnotation) {

    }

    @Override
    public boolean isValid(String speciality, ConstraintValidatorContext context) {

        boolean flag = false;

        speciality = speciality.toUpperCase();

        for(Speciality spec: Speciality.values()) {
            if(spec.name().equals(speciality)) {
                flag = true;
                break;
            }
        }

        return flag;
    }
}