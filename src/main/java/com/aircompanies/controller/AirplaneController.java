package com.aircompanies.controller;

import com.aircompanies.dto.airplane.AirplaneDto;
import com.aircompanies.dto.airplane.AirplanePostDto;
import com.aircompanies.entity.Airplane;
import com.aircompanies.service.AirplaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.aircompanies.constants.ResourceMapping.*;

@RestController
@RequestMapping(AIRPLANE)
public class AirplaneController {

    private final AirplaneService airplaneService;

    @Autowired
    public AirplaneController(AirplaneService airplaneService) {
        this.airplaneService = airplaneService;
    }

    @PutMapping(ID_PATH_VARIABLE + CHANGE_COMPANY)
    public ResponseEntity<Airplane> updateCompany(@PathVariable Long id, @RequestParam Long companyId) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(airplaneService.updateCompany(id, companyId));
    }

    @PostMapping
    public ResponseEntity<Airplane> save(@Valid @RequestBody AirplanePostDto airplanePostDto) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(airplaneService.save(airplanePostDto));
    }

    @GetMapping(ID)
    public AirplaneDto findAirplaneById(@RequestParam Long id) {
        return airplaneService.findAirplaneById(id);
    }
}
