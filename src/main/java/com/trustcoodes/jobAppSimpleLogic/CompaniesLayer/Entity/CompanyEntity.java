package com.trustcoodes.jobAppSimpleLogic.CompaniesLayer.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.trustcoodes.jobAppSimpleLogic.JobLayer.Entity.JobEntity;
import com.trustcoodes.jobAppSimpleLogic.ReviewLayer.Entity.ReviewEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity(name = "CompanyData")
public class CompanyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String companyName;
    private String info;

    @OneToMany(mappedBy = "companyEntity")
    @JsonIgnore
    private List<JobEntity> entityList;

    @OneToMany(mappedBy = "companyEntity", fetch = FetchType.EAGER)
    private List<ReviewEntity> reviewEntity;

}
