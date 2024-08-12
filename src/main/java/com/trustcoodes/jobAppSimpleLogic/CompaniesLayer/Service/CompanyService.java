package com.trustcoodes.jobAppSimpleLogic.CompaniesLayer.Service;

import com.trustcoodes.jobAppSimpleLogic.CompaniesLayer.Entity.CompanyEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CompanyService {
    List<CompanyEntity> findAllCompanies();

    CompanyEntity findCompanyById(Long id);

    void addCompany(CompanyEntity company);

    boolean removeCompanyById(Long id);

    boolean updateCompanyById(Long id, CompanyEntity entity);
}
