package com.aircompanies.service;

import com.aircompanies.dto.airplane.AirplaneDto;
import com.aircompanies.dto.airplane.AirplanePostDto;
import com.aircompanies.entity.Airplane;

public interface AirplaneService {

    Airplane save(AirplanePostDto airplanePostDto);

    AirplaneDto findAirplaneById(Long id);

    Airplane updateCompany(Long airplaneId, Long companyId);
}