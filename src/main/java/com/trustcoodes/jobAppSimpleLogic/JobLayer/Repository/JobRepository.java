package com.trustcoodes.jobAppSimpleLogic.JobLayer.Repository;

import com.trustcoodes.jobAppSimpleLogic.JobLayer.Entity.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public interface JobRepository extends JpaRepository<JobEntity, Long> {
    List<JobEntity> jobEntity = new ArrayList<>();
}
