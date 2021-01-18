package com.aircompanies.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

import static com.aircompanies.constants.DBConstant.AIR_COMPANY_TABLE;

@Builder
@Table(name = AIR_COMPANY_TABLE)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AirCompany {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToOne
    private CompanyType companyType;

    @Column(nullable = false)
    private Date createdAt;

    @JsonIgnore
    @OneToMany(mappedBy = "airCompany", fetch = FetchType.LAZY)
    private List<Flight> flights;

    @JsonIgnore
    @OneToMany(mappedBy = "airCompany", fetch = FetchType.LAZY)
    private List<Airplane> airplanes;

}