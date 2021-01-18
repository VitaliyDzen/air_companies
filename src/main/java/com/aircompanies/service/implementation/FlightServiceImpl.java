package com.aircompanies.service.implementation;

import com.aircompanies.constants.ErrorMessage;
import com.aircompanies.dto.flight.FlightDto;
import com.aircompanies.dto.flight.FlightPostDto;
import com.aircompanies.entity.Flight;
import com.aircompanies.entity.enums.FlightStatus;
import com.aircompanies.exception.NotFoundException;
import com.aircompanies.exception.NotUpdatedException;
import com.aircompanies.repository.AirCompanyRepository;
import com.aircompanies.repository.FlightRepository;
import com.aircompanies.service.FlightService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FlightServiceImpl implements FlightService {

    private final ModelMapper modelMapper;
    private final FlightRepository flightRepository;
    private final AirCompanyRepository airCompanyRepository;

    @Autowired
    public FlightServiceImpl(ModelMapper modelMapper, FlightRepository flightRepository,
                             AirCompanyRepository airCompanyRepository) {
        this.modelMapper = modelMapper;
        this.flightRepository = flightRepository;
        this.airCompanyRepository = airCompanyRepository;
    }

    @Override
    public List<FlightDto> findAllByFlightStatusAndAirCompany_Name(FlightStatus flightStatus, String airCompanyName) {
        return modelMapper
                .map(flightRepository.findAllByFlightStatusAndAirCompany_Name(flightStatus, airCompanyName),
                        new TypeToken<List<FlightDto>>() {
                        }.getType());
    }

    @Override
    public List<FlightDto> findAllByFlightByActiveStatusAndLessThanYesterday() {
        Date currentDate = new java.util.Date();
        return modelMapper
                .map(flightRepository.findAllByFlightStatusAndCreatedAtLessThan(FlightStatus.ACTIVE, currentDate),
                        new TypeToken<List<FlightDto>>() {
                        }.getType());
    }

    @Override
    public List<FlightDto> findAllByFlightStatusCOMPLETEDAndDelayed() {
        return modelMapper
                .map(flightRepository.findAllByFlightStatusCOMPLETEDAndDelayed(),
                        new TypeToken<List<FlightDto>>() {
                        }.getType());
    }

    @Override
    public Flight save(FlightPostDto flightPostDto) {
        Flight flight = modelMapper.map(flightPostDto, Flight.class);
        flight.setFlightStatus(FlightStatus.PENDING);
        return flightRepository.save(flight);
    }

    @Override
    public Flight updateStatus(FlightStatus flightStatus, Long id) {
        Date currentDate = new java.util.Date();

        if (flightStatus.equals(FlightStatus.DELAYED)) {
            return flightRepository.findById(id)
                    .map(flight -> {
                        flight.setFlightStatus(flightStatus);
                        flight.setDelayStartedAt(currentDate);
                        return flightRepository.save(flight);
                    }).orElseThrow(() -> new NotUpdatedException(ErrorMessage.CANT_SET_FLIGHT_STATUS_PENDING));

        } else if (flightStatus.equals(FlightStatus.ACTIVE)) {
            return flightRepository.findById(id)
                    .map(flight -> {
                        flight.setFlightStatus(flightStatus);
                        flight.setCreatedAt(currentDate);
                        return flightRepository.save(flight);
                    }).orElseThrow(() -> new NotUpdatedException(ErrorMessage.CANT_SET_FLIGHT_STATUS_PENDING));

        } else if (flightStatus.equals(FlightStatus.COMPLETED)) {
            return flightRepository.findById(id)
                    .map(flight -> {
                        flight.setFlightStatus(flightStatus);
                        flight.setEndedAt(currentDate);
                        return flightRepository.save(flight);
                    }).orElseThrow(() -> new NotUpdatedException(ErrorMessage.CANT_SET_FLIGHT_STATUS_PENDING));

        } else if (flightStatus.equals(FlightStatus.PENDING)) {
            throw new NotUpdatedException(ErrorMessage.CANT_SET_FLIGHT_STATUS_PENDING);
        } else {
            throw new NotUpdatedException(ErrorMessage.CANT_SET_FLIGHT_STATUS_PENDING);
        }
    }

    @Override
    public FlightDto findFlightById(Long id) {
        return modelMapper.map(flightRepository
                        .findById(id)
                        .orElseThrow(() -> new NotFoundException(ErrorMessage.FLIGHT_NOT_FOUND_WITH_ID + id)),
                FlightDto.class);
    }
}