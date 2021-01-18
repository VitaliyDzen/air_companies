package com.aircompanies.controller;

import com.aircompanies.dto.flight.FlightDto;
import com.aircompanies.dto.flight.FlightPostDto;
import com.aircompanies.entity.Flight;
import com.aircompanies.entity.enums.FlightStatus;
import com.aircompanies.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.aircompanies.constants.ResourceMapping.FLIGHT;
import static com.aircompanies.constants.ResourceMapping.ID;

@RestController
@RequestMapping(FLIGHT)
public class FlightController {
    private final FlightService flightService;

    @Autowired
    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("/status/active/date/yesterday")
    public List<FlightDto> findAllByFlightByActiveStatusAndLessThanYesterday() {
        return flightService.findAllByFlightByActiveStatusAndLessThanYesterday();
    }

    @PostMapping
    public ResponseEntity<Flight> save(@Valid @RequestBody FlightPostDto flightPostDto) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(flightService.save(flightPostDto));
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Flight> updateStatus(@RequestParam FlightStatus flightStatus, @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(flightService.updateStatus(flightStatus, id));
    }

    @GetMapping(ID)
    public FlightDto findFlightById(@RequestParam Long id) {
        return flightService.findFlightById(id);
    }

    @GetMapping("/status/completed/delayed")
    public List<FlightDto> findAllByFlightStatusCOMPLETEDAndDelayed() {
        return flightService.findAllByFlightStatusCOMPLETEDAndDelayed();
    }
}
