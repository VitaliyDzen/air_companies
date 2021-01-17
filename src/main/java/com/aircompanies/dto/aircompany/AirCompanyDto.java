package com.aircompanies.dto.aircompany;

import com.aircompanies.dto.airplane.AirplaneDto;
import com.aircompanies.dto.companytype.CompanyTypeDto;
import com.aircompanies.dto.flight.FlightDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AirCompanyDto {
    private Long id;
    private String name;
    private CompanyTypeDto companyType;
    private Date createdAt;
    @JsonIgnore
    private List<FlightDto> flights;
    @JsonIgnore
    private List<AirplaneDto> airplanes;
}
