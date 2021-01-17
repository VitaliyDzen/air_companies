package com.aircompanies.dto.country;

import com.aircompanies.entity.AirCompany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountryDto {
    private Long id;
    private String name;
}
