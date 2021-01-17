package com.aircompanies.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

import static com.aircompanies.constants.DBConstant.COMPANY_TYPE_TABLE;

@Builder
@Table(name = COMPANY_TYPE_TABLE)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String type;

    @JsonIgnore
    @OneToMany(mappedBy = "companyType", fetch = FetchType.LAZY)
    private List<AirCompany> airCompanies;
}