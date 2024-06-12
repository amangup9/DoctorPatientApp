package com.medical.connect.controller;


import com.medical.connect.dto.DoctorDto;
import com.medical.connect.service.DoctorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.medical.connect.util.Constants.Paths.DOCTOR_PATH;


@RestController
@RequestMapping(DOCTOR_PATH)
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    /**
     * Save Doctor
     * @return doctorDto
     */
    @Operation(summary = "Save a doctor")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Saved doctor",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = DoctorDto.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid Input")
    })
    @PostMapping
    public ResponseEntity<DoctorDto> saveDoctor(@Valid @RequestBody DoctorDto doctorDto) {
        return ResponseEntity.ok(doctorService.saveDoctor(doctorDto));
    }

    /**
     * Delete doctor by ID.
     */
    @Operation(summary = "Delete a doctor")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Doctor deleted"),
            @ApiResponse(responseCode = "404", description = "Doctor with given ID not exist")
    })
    @DeleteMapping
    public void deleteById(@RequestParam int id) {
        doctorService.deleteById(id);
    }
}

