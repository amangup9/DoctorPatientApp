package com.medical.connect.validation;

import com.medical.connect.validation.validator.CityValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

import static com.medical.connect.util.Constants.Exception.CITY_NOT_EXIST;
import static com.medical.connect.util.Constants.Exception.EMPTY_STRING;

@Documented
@Constraint(validatedBy = CityValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidCity {
    String locale() default EMPTY_STRING;

    String message() default CITY_NOT_EXIST;
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}