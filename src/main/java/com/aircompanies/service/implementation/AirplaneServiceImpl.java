package com.aircompanies.service.implementation;

import com.aircompanies.constants.ErrorMessage;
import com.aircompanies.dto.airplane.AirplaneDto;
import com.aircompanies.dto.airplane.AirplanePostDto;
import com.aircompanies.entity.AirCompany;
import com.aircompanies.entity.Airplane;
import com.aircompanies.exception.NotFoundException;
import com.aircompanies.exception.NotUpdatedException;
import com.aircompanies.repository.AirCompanyRepository;
import com.aircompanies.repository.AirplaneRepository;
import com.aircompanies.service.AirplaneService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirplaneServiceImpl implements AirplaneService {

    private final ModelMapper modelMapper;
    private final AirplaneRepository airplaneRepository;
    private final AirCompanyRepository airCompanyRepository;

    @Autowired
    public AirplaneServiceImpl(ModelMapper modelMapper, AirplaneRepository airplaneRepository,
                               AirCompanyRepository airCompanyRepository) {
        this.modelMapper = modelMapper;
        this.airplaneRepository = airplaneRepository;
        this.airCompanyRepository = airCompanyRepository;
    }

    @Override
    public Airplane save(AirplanePostDto airplanePostDto) {
        Airplane airplane = modelMapper.map(airplanePostDto, Airplane.class);
        airplane.setNumberOfFlights(0);
        return airplaneRepository.save(airplane);
    }

    @Override
    public AirplaneDto findAirplaneById(Long id) {
        return modelMapper.map(airplaneRepository
                        .findById(id)
                        .orElseThrow(() -> new NotFoundException(ErrorMessage.AIRPLANE_NOT_FOUND_WITH_ID + id)),
                AirplaneDto.class);
    }

    @Override
    public Airplane updateCompany(Long airplaneId, Long companyId) {
        AirCompany airCompany = airCompanyRepository
                .findById(companyId)
                .orElseThrow(() -> new NotUpdatedException(ErrorMessage.AIR_COMPANY_NOT_FOUND_WITH_ID + companyId));

        return airplaneRepository.findById(airplaneId)
                .map(airplane -> {
                    airplane.setAirCompany(airCompany);
                    return airplaneRepository.save(airplane);
                }).orElseThrow(() -> new NotUpdatedException(ErrorMessage.AIRPLANE_NOT_UPDATED_WITH_ID + airplaneId));
    }
}
