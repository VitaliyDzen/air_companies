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

import static com.aircompanies.constants.ResourceMapping.*;

@RestController
@RequestMapping(FLIGHT)
public class FlightController {
    private final FlightService flightService;

    @Autowired
    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping(STATUS + ACTIVE_DATE_YESTERDAY)
    public List<FlightDto> findAllByFlightByActiveStatusAndLessThanYesterday() {
        return flightService.findAllByFlightByActiveStatusAndLessThanYesterday();
    }

    @PostMapping
    public ResponseEntity<Flight> save(@Valid @RequestBody FlightPostDto flightPostDto) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(flightService.save(flightPostDto));
    }

    @PutMapping(ID_PATH_VARIABLE + STATUS)
    public ResponseEntity<Flight> updateStatus(@RequestParam FlightStatus flightStatus, @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(flightService.updateStatus(flightStatus, id));
    }

    @GetMapping(ID)
    public FlightDto findFlightById(@RequestParam Long id) {
        return flightService.findFlightById(id);
    }

    @GetMapping(STATUS + COMPLETED_DELAYED)
    public List<FlightDto> findAllByFlightStatusCOMPLETEDAndDelayed() {
        return flightService.findAllByFlightStatusCOMPLETEDAndDelayed();
    }
}
