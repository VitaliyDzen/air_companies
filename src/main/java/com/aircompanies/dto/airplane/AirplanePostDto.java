package com.aircompanies.dto.airplane;

import com.aircompanies.dto.aircompany.AirCompanyDto;
import com.aircompanies.dto.airplanetype.AirplaneTypeDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AirplanePostDto {
    private String name;
    private String factorySerialNumber;
    private AirCompanyDto airCompany;
    private Float flightDistance;
    private Float fuelCapacity;
    private AirplaneTypeDto airplaneType;
    private Date createdAt;
}