package com.medical.connect.validation;

import com.medical.connect.validation.validator.SymptomValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

import static com.medical.connect.util.Constants.Exception.EMPTY_STRING;
import static com.medical.connect.util.Constants.Exception.INVALID_SYMPTOM;

@Documented
@Constraint(validatedBy = SymptomValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidSymptom {
    String locale() default EMPTY_STRING;

    String message() default INVALID_SYMPTOM;
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}