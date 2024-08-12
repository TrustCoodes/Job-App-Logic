package com.trustcoodes.jobAppSimpleLogic.CompaniesLayer.Service.Implement;

import com.trustcoodes.jobAppSimpleLogic.CompaniesLayer.Entity.CompanyEntity;
import com.trustcoodes.jobAppSimpleLogic.CompaniesLayer.Repository.CompanyRepository;
import com.trustcoodes.jobAppSimpleLogic.CompaniesLayer.Service.CompanyService;
import com.trustcoodes.jobAppSimpleLogic.Exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyImpl implements CompanyService {

    @Autowired
    private final CompanyRepository companyRepository;

    @Override
    public List<CompanyEntity> findAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public CompanyEntity findCompanyById(Long id) {
        return companyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Company not found with id: " + id));
    }

    @Override
    public void addCompany(CompanyEntity company) {
        companyRepository.save(company);
    }

    @Override
    public boolean removeCompanyById(Long id) {
        if (companyRepository.existsById(id)) {
            companyRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateCompanyById(Long id, CompanyEntity companyEntity) {
        Optional<CompanyEntity> optional = companyRepository.findById(id);
        if (optional.isPresent()) {
            CompanyEntity entity = optional.get();
            entity.setCompanyName(companyEntity.getCompanyName());
            entity.setInfo(companyEntity.getInfo());
            entity.setEntityList(companyEntity.getEntityList());
            companyRepository.save(entity);
            return true;
        }
        return false;
    }

}