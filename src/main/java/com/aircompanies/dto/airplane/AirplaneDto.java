package com.aircompanies.dto.airplane;

import com.aircompanies.dto.aircompany.AirCompanyDto;
import com.aircompanies.dto.airplanetype.AirplaneTypeDto;
import com.aircompanies.entity.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AirplaneDto {
    private Long id;
    private String name;
    private String factorySerialNumber;
    private AirCompanyDto airCompany;
    private Integer numberOfFlights;
    private Float flightDistance;
    private Float fuelCapacity;
    private AirplaneTypeDto airplaneType;
    private Date createdAt;
}
