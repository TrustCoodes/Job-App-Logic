package com.trustcoodes.jobAppSimpleLogic.CompaniesLayer.Repository;

import com.trustcoodes.jobAppSimpleLogic.CompaniesLayer.Entity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public interface CompanyRepository extends JpaRepository<CompanyEntity, Long> {
    List<CompanyEntity> companyEntity = new ArrayList<>();
}
