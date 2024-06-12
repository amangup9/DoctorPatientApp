package com.medical.connect.controller;


import com.medical.connect.dto.DoctorDto;
import com.medical.connect.service.QueryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.medical.connect.util.Constants.Paths.QUERY_PATH;

@RestController
@RequestMapping(QUERY_PATH)
public class QueryController {

    @Autowired
    private QueryService queryService;

    /**
     * return list of available doctors in patient city based on symptoms
     * */
    @Operation(summary = "Return list of available doctors in patient city based on symptoms")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of Doctors",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = List.class))}),
            @ApiResponse(responseCode = "404", description = "Either any doctors not exist in the city yet " +
                    "or No doctor exist in that city for specific symptom " +
                    "or patient with given ID doesn't exist")
    })
    @GetMapping
    ResponseEntity<Page<DoctorDto>> getDoctors(@RequestParam Integer patientId, Pageable pageable) {
        Page<DoctorDto> responses = queryService.getDoctors(patientId, pageable);
        return ResponseEntity.ok(responses);
    }
}
