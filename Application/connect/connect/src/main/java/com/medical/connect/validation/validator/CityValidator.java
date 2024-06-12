package com.medical.connect.validation.validator;


import com.medical.connect.util.City;
import com.medical.connect.validation.ValidCity;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class CityValidator implements ConstraintValidator<ValidCity, String> {

    @Override
    public void initialize(ValidCity constraintAnnotation) {

    }

    @Override
    public boolean isValid(String city, ConstraintValidatorContext context) {

        boolean flag = false;

        city = city.toUpperCase();

        for(City city1: City.values()) {
            if(city1.name().equals(city)) {
                flag = true;
                break;
            }
        }

        return flag;
    }
}