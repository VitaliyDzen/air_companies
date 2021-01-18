package com.aircompanies.controller;

import com.aircompanies.dto.aircompany.AirCompanyDto;
import com.aircompanies.dto.aircompany.AirCompanyPostDto;
import com.aircompanies.dto.flight.FlightDto;
import com.aircompanies.entity.AirCompany;
import com.aircompanies.entity.enums.FlightStatus;
import com.aircompanies.service.AirCompanyService;
import com.aircompanies.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.aircompanies.constants.ResourceMapping.*;

@RestController
@RequestMapping(AIR_COMPANY)
public class AirCompanyController {

    private final AirCompanyService airCompanyService;
    private final FlightService flightService;

    @Autowired
    public AirCompanyController(AirCompanyService airCompanyService, FlightService flightService) {
        this.airCompanyService = airCompanyService;
        this.flightService = flightService;
    }

    @GetMapping
    public List<AirCompanyDto> findAllAirCompanies() {
        return airCompanyService.findAllAirCompanies();
    }

    @GetMapping(NAME_COMPANY_NAME_FLIGHTS_STATUS)
    public List<FlightDto> findAllFlightsByFlightStatusAndAirCompany_Name(@RequestParam FlightStatus status, @PathVariable String companyName) {
        return flightService.findAllByFlightStatusAndAirCompany_Name(status, companyName);
    }

    @GetMapping(ID)
    public AirCompanyDto findAirCompanyById(@RequestParam Long id) {
        return airCompanyService.findAirCompanyById(id);
    }

    @GetMapping(NAME)
    public AirCompanyDto findAirCompanyByName(@RequestParam String name) {
        return airCompanyService.findAirCompanyByName(name);
    }

    @PostMapping
    public ResponseEntity<AirCompany> save(@Valid @RequestBody AirCompanyPostDto airCompanyPostDto) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(airCompanyService.save(airCompanyPostDto));
    }

    @PutMapping(ID_PATH_VARIABLE)
    public ResponseEntity<AirCompany> update(@Valid @RequestBody AirCompanyDto airCompanyDto, @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(airCompanyService.update(airCompanyDto, id));
    }

    @DeleteMapping(ID_PATH_VARIABLE)
    public void delete(@PathVariable Long id) {
        airCompanyService.delete(id);
    }

}
