package com.aircompanies.service.implementation;

import com.aircompanies.constants.ErrorMessage;
import com.aircompanies.dto.aircompany.AirCompanyDto;
import com.aircompanies.dto.aircompany.AirCompanyPostDto;
import com.aircompanies.entity.AirCompany;
import com.aircompanies.entity.CompanyType;
import com.aircompanies.exception.NotDeletedException;
import com.aircompanies.exception.NotFoundException;
import com.aircompanies.exception.NotUpdatedException;
import com.aircompanies.repository.AirCompanyRepository;
import com.aircompanies.service.AirCompanyService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirCompanyServiceImpl implements AirCompanyService {

    private final AirCompanyRepository airCompanyRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public AirCompanyServiceImpl(AirCompanyRepository airCompanyRepository, ModelMapper modelMapper) {
        this.airCompanyRepository = airCompanyRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<AirCompanyDto> findAllAirCompanies() {
        return modelMapper
                .map(airCompanyRepository.findAll(), new TypeToken<List<AirCompanyDto>>() {
                }.getType());
    }

    @Override
    public AirCompanyDto findAirCompanyById(Long id) {
        return modelMapper.map(airCompanyRepository
                        .findById(id)
                        .orElseThrow(() -> new NotFoundException(ErrorMessage.AIR_COMPANY_NOT_FOUND_WITH_ID + id)),
                AirCompanyDto.class);
    }

    @Override
    public AirCompanyDto findAirCompanyByName(String name) {
        return modelMapper.map(airCompanyRepository
                        .findByName(name)
                        .orElseThrow(() -> new NotFoundException(ErrorMessage.AIR_COMPANY_NOT_FOUND_WITH_NAME + name)),
                AirCompanyDto.class);
    }

    @Override
    public AirCompany save(AirCompanyPostDto airCompanyPostDTO) {
        return airCompanyRepository.save(modelMapper.map(airCompanyPostDTO, AirCompany.class));
    }

    @Override
    public AirCompany update(AirCompanyDto airCompanyDTO, Long id) {
        return airCompanyRepository.findById(id)
                .map(airCompany -> {
                    airCompany.setCompanyType(modelMapper.map(airCompanyDTO.getCompanyType(), CompanyType.class));
                    airCompany.setCreatedAt(airCompanyDTO.getCreatedAt());
                    airCompany.setName(airCompanyDTO.getName());
                    return airCompanyRepository.save(airCompany);
                }).orElseThrow(() -> new NotUpdatedException(ErrorMessage.AIR_COMPANY_NOT_UPDATED_WITH_ID + id));
    }

    @Override
    public void delete(Long id) {
        try {
            airCompanyRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new NotDeletedException(ErrorMessage.AIR_COMPANY_NOT_DELETED_WITH_ID + id);
        }
    }
}
