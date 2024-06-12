package com.medical.connect.dto;

import com.medical.connect.validation.ValidSymptom;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import static com.medical.connect.util.Constants.Validation.*;
import static com.medical.connect.util.Constants.Regex.EMAIL_REGEX;
import static com.medical.connect.util.Constants.Regex.PHONE_REGEX;

@Getter
@Setter
@AllArgsConstructor
public class PatientDto {
    private int id;

    @NotBlank(message = EMPTY_NAME)
    @Size(min = 3, message = INVALID_NAME)
    private String name;

    @NotBlank(message = EMPTY_CITY)
    @Size(max = 20, message = INVALID_CITY)
    private String city;

    @Email(regexp = EMAIL_REGEX, message = INVALID_EMAIL)
    private String email;

    @NotBlank(message = EMPTY_PHONE)
    @Pattern(regexp = PHONE_REGEX, message = INVALID_PHONE)
    private String phone;

    // Assuming single valued symptom
    @NotBlank
    @ValidSymptom
    private String symptom;
}
