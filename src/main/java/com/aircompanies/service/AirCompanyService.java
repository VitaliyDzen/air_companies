package com.aircompanies.service;

import com.aircompanies.dto.aircompany.AirCompanyDto;
import com.aircompanies.dto.aircompany.AirCompanyPostDto;
import com.aircompanies.entity.AirCompany;

import java.util.List;

public interface AirCompanyService {

    List<AirCompanyDto> findAllAirCompanies();

    AirCompanyDto findAirCompanyById(Long id);

    AirCompanyDto findAirCompanyByName(String name);

    AirCompany save(AirCompanyPostDto airCompanyPostDTO);

    AirCompany update(AirCompanyDto airCompanyDTO, Long id);

    void delete(Long id);
}
