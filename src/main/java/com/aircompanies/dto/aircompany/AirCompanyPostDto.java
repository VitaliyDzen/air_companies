package com.aircompanies.dto.aircompany;

import com.aircompanies.dto.companytype.CompanyTypeDto;
import com.aircompanies.entity.CompanyType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AirCompanyPostDto {
    private String name;
    private CompanyTypeDto companyType;
    private Date createdAt;
}
