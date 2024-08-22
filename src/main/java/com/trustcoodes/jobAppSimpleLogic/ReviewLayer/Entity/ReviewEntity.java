package com.trustcoodes.jobAppSimpleLogic.ReviewLayer.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.trustcoodes.jobAppSimpleLogic.CompaniesLayer.Entity.CompanyEntity;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "Review")
public class ReviewEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String heading;
    private String info;
    private double reviewRating;

    @JsonIgnore
    @ManyToOne
    private CompanyEntity companyEntity;
}