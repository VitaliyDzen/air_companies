package com.aircompanies.dto.companytype;

import com.aircompanies.dto.aircompany.AirCompanyDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyTypeDto {
    private Long id;
    private String type;
    @JsonIgnore
    private List<AirCompanyDto> airCompanies;
}
