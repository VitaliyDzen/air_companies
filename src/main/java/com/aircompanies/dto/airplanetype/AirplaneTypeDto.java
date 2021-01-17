package com.aircompanies.dto.airplanetype;

import com.aircompanies.dto.airplane.AirplaneDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AirplaneTypeDto {
    private Long id;
    private String type;
    @JsonIgnore
    private List<AirplaneDto> airplanes;
}
