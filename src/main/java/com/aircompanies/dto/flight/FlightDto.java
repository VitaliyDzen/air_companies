package com.aircompanies.dto.flight;

import com.aircompanies.dto.aircompany.AirCompanyDto;
import com.aircompanies.dto.airplane.AirplaneDto;
import com.aircompanies.dto.country.CountryDto;
import com.aircompanies.entity.AirCompany;
import com.aircompanies.entity.Airplane;
import com.aircompanies.entity.Country;
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
    private AirCompanyDto airCompany;
    private AirplaneDto airplane;
    private CountryDto departureCountry;
    private CountryDto destinationCountry;
    private Float distance;
    private Time estimatedFlightTime;
    private Date endedAt;
    private Date delayStartedAt;
    private Date createdAt;
}
