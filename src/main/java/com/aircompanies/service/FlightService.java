package com.aircompanies.service;

import com.aircompanies.dto.flight.FlightDto;
import com.aircompanies.dto.flight.FlightPostDto;
import com.aircompanies.entity.Flight;
import com.aircompanies.entity.enums.FlightStatus;

import java.util.List;

public interface FlightService {

    List<FlightDto> findAllByFlightStatusAndAirCompany_Name(FlightStatus flightStatus, String airCompanyName);

    List<FlightDto> findAllByFlightByActiveStatusAndLessThanYesterday();

    List<FlightDto> findAllByFlightStatusCOMPLETEDAndDelayed();

    Flight save(FlightPostDto flightPostDto);

    Flight updateStatus(FlightStatus flightStatus, Long id);

    FlightDto findFlightById(Long id);
}
