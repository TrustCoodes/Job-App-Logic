package com.trustcoodes.jobAppSimpleLogic.ReviewLayer.Repository;

import com.trustcoodes.jobAppSimpleLogic.ReviewLayer.Entity.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public interface ReviewRepo extends JpaRepository<ReviewEntity, Long> {
    List<ReviewEntity> reviewEntity = new ArrayList<>();
}
