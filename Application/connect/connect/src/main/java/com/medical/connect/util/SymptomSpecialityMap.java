package com.medical.connect.util;

import java.util.HashMap;

import static com.medical.connect.util.Symptom.*;
import static com.medical.connect.util.Speciality.*;

public class SymptomSpecialityMap {
    public static final HashMap<Symptom, Speciality> SYMPTOM_SPECIALITY_HASH_MAP = new HashMap<>(){{
        put(ARTHRITIS, ORTHOPEDIC);
        put(BACK_PAIN, ORTHOPEDIC);
        put(TISSUE_INJURIES, ORTHOPEDIC);
        put(DYSMENORRHEA, GYNECOLOGY);
        put(SKIN_INFECTION, DERMATOLOGY);
        put(SKIN_BURN, DERMATOLOGY);
        put(EAR_PAIN, ENT_SPECIALIST);
    }};
}
