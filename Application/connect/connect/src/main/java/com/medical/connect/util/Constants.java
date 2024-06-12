package com.medical.connect.util;


public class Constants {

    public static final class Paths {
        public static final String DOCTOR_PATH = "/doctor";
        public static final String PATIENT_PATH = "/patient";
        public static final String QUERY_PATH = "/query";
    }

    public static final class Validation {
        public static final String EMPTY_NAME = "Name can't be empty";
        public static final String INVALID_NAME = "Name should have at least 3 characters";
        public static final String EMPTY_CITY = "City can't be empty";
        public static final String INVALID_CITY = "City should have at max 20 characters";
        public static final String INVALID_EMAIL = "Email should be valid";
        public static final String EMPTY_PHONE = "Phone number must not be blank";
        public static final String INVALID_PHONE = "Phone number must have at least 10 digits";

    }

    public static final class Regex {
        public static final String EMAIL_REGEX = ".+[@].+[\\.].+";
        public static final String PHONE_REGEX = "\\d{10,}";
    }

    public static final class Exception {
        public static final String EMPTY_STRING = "";
        public static final String INVALID_PATIENT = "Patient with given Id doesn't exist";
        public static final String INVALID_DOCTOR = "Doctor with given Id doesn't exist";
        public static final String DOCTOR_NOT_EXIST = "We are still waiting to expand to your location";
        public static final String DOCTOR_WITH_SYMPTOM_NOT_EXIST = "There isn’t any doctor present at your location for your symptom";
        public static final String CITY_NOT_EXIST = "Invalid City";
        public static final String INVALID_SPECIALITY = "Invalid Speciality";
        public static final String INVALID_SYMPTOM = "Invalid Symptom";
        public static final String NOT_KNOWN_SPECIALITY = "We don't know speciality for his symptom yet";
    }
}
