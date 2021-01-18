package com.aircompanies.repository;

import com.aircompanies.entity.Flight;
import com.aircompanies.entity.enums.FlightStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
    List<Flight> findAllByFlightStatusAndAirCompany_Name(FlightStatus flightStatus, String airCompanyName);

    List<Flight> findAllByFlightStatusAndCreatedAtLessThan(FlightStatus flightStatus, Date date);

    @Query(value = "SELECT * from Flight f WHERE f.flight_status='COMPLETED' " +
            "and f.ended_at - f.created_at > f.estimated_flight_time", nativeQuery = true)
    List<Flight> findAllByFlightStatusCOMPLETEDAndDelayed();
}