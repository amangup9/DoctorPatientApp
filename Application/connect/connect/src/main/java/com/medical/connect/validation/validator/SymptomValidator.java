package com.medical.connect.validation.validator;


import com.medical.connect.util.Symptom;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import com.medical.connect.validation.ValidSymptom;


public class SymptomValidator implements ConstraintValidator<ValidSymptom, String> {

    @Override
    public void initialize(ValidSymptom constraintAnnotation) {

    }

    @Override
    public boolean isValid(String symptom, ConstraintValidatorContext context) {

        boolean flag = false;

        symptom = symptom.toUpperCase();

        for(Symptom symp : Symptom.values()) {
            if(symp.name().equals(symptom)) {
                flag = true;
                break;
            }
        }

        return flag;
    }
}