package com.medical.connect.controller;


import com.medical.connect.dto.PatientDto;
import com.medical.connect.service.PatientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import static com.medical.connect.util.Constants.Paths.PATIENT_PATH;


@RestController
@RequestMapping(PATIENT_PATH)
public class PatientController {

    @Autowired
    private PatientService patientService;

    /**
     * Save Patient
     * @return patientDto
     */
    @Operation(summary = "Save a Patient")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Saved Patient",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PatientDto.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid Input")
    })
    @PostMapping
    public ResponseEntity<PatientDto> savePatient(@Valid @RequestBody PatientDto patientDto) {
        return ResponseEntity.ok(patientService.savePatient(patientDto));
    }

    /**
     * Delete patient by ID.
     */
    @Operation(summary = "Delete a patient")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Patient deleted"),
            @ApiResponse(responseCode = "404", description = "Patient with given ID not exist")
    })
    @DeleteMapping
    public void deleteById(@RequestParam int id) {
        patientService.deleteById(id);
    }
}

