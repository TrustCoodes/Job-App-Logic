package com.trustcoodes.jobAppSimpleLogic.JobLayer.Service.Implement;

import com.trustcoodes.jobAppSimpleLogic.Exceptions.ResourceNotFoundException;
import com.trustcoodes.jobAppSimpleLogic.JobLayer.Entity.JobEntity;
import com.trustcoodes.jobAppSimpleLogic.JobLayer.Repository.JobRepository;
import com.trustcoodes.jobAppSimpleLogic.JobLayer.Service.JobAppService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JobAppImpl implements JobAppService {
    private final JobRepository jobRepository;

    @Override
    public List<JobEntity> findAllJobs() {
        return jobRepository.findAll();
    }

    @Override
    public void addJob(JobEntity jobEntity) {
        jobRepository.save(jobEntity);  // Let the DB handle ID generation
    }

    @Override
    public JobEntity findJobById(Long id) {
        return jobRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Job not found with id: " + id));
    }

    @Override
    public boolean removeJobById(Long id) {
        if (jobRepository.existsById(id)) {
            jobRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateJobById(Long id, JobEntity entities) {
        Optional<JobEntity> optional = jobRepository.findById(id);
        if (optional.isPresent()) {
            JobEntity entity = optional.get();
            entity.setRole(entities.getRole());
            entity.setPosition(entities.getPosition());
            entity.setOfficeLocation(entities.getOfficeLocation());
            entity.setMinSalary(entities.getMinSalary());
            entity.setMaxSalary(entities.getMaxSalary());
            jobRepository.save(entity);  // Save the updated entity
            return true;
        }
        return false;
    }
}
