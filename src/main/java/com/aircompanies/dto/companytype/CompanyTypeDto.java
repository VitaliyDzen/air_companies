package com.aircompanies.dto.companytype;

import com.aircompanies.dto.aircompany.AirCompanyDto;
import com.aircompanies.dto.airplane.AirplaneDto;
import com.aircompanies.entity.AirCompany;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
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
