package com.trustcoodes.jobAppSimpleLogic.ReviewLayer.Entity;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name = "Review")
public class ReviewEntity {
    private Long id;
    private String heading;
    private String info;
    private double reviewRating;
}