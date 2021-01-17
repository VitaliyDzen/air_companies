package com.aircompanies.entity;

import com.aircompanies.entity.enums.FlightStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

import static com.aircompanies.constants.DBConstant.FLIGHT_TABLE;

@Builder
@Table(name = FLIGHT_TABLE)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private FlightStatus flightStatus;

    @ManyToOne
    private AirCompany airCompany;

    @ManyToOne
    private Airplane airplane;

    @OneToOne
    private Country departureCountry;

    @OneToOne
    private Country destinationCountry;

    @Column(nullable = false)
    private Float distance;

    @Column(nullable = false)
    private Time estimatedFlightTime;

    @Column
    private Date endedAt;

    @Column
    private Date delayStartedAt;

    @Column
    private Date createdAt;
}