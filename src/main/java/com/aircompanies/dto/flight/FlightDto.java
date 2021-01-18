package com.aircompanies.dto.flight;

import com.aircompanies.dto.aircompany.AirCompanyNameDto;
import com.aircompanies.dto.airplane.AirplaneNameDto;
import com.aircompanies.dto.country.CountryNameDto;
import com.aircompanies.entity.enums.FlightStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlightDto {
    private Long id;
    private FlightStatus flightStatus;
    private AirCompanyNameDto airCompany;
    private AirplaneNameDto airplane;
    private CountryNameDto departureCountry;
    private CountryNameDto destinationCountry;
    private Float distance;
    private Time estimatedFlightTime;
    private Date endedAt;
    private Date delayStartedAt;
    private Date createdAt;
}
