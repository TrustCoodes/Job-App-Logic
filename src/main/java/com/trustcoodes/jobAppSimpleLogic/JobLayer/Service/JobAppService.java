package com.trustcoodes.jobAppSimpleLogic.JobLayer.Service;

import com.trustcoodes.jobAppSimpleLogic.JobLayer.Entity.JobEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface JobAppService {
    List<JobEntity> findAllJobs();
    void addJob(JobEntity jobEntity);
    JobEntity findJobById(Long id);
    boolean removeJobById(Long id);
    boolean updateJobById(Long id, JobEntity entities);
}