package com.aircompanies.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

import static com.aircompanies.constants.DBConstant.AIRPLANE_TABLE;

@Builder
@Table(name = AIRPLANE_TABLE)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Airplane {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String factorySerialNumber;

    @ManyToOne
    private AirCompany airCompany;

    @Column(nullable = false)
    private Integer numberOfFlights;

    @Column(nullable = false)
    private Float flightDistance;

    @Column(nullable = false)
    private Float fuelCapacity;

    @ManyToOne
    private AirplaneType airplaneType;

    @Column(nullable = false)
    private Date createdAt;
}