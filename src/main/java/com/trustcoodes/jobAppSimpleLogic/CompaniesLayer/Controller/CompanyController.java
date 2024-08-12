package com.trustcoodes.jobAppSimpleLogic.CompaniesLayer.Controller;

import com.trustcoodes.jobAppSimpleLogic.CompaniesLayer.Entity.CompanyEntity;
import com.trustcoodes.jobAppSimpleLogic.CompaniesLayer.Service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    private final CompanyService companyService;

    @GetMapping
    public ResponseEntity<List<CompanyEntity>> findAllCompanies() {
        return ResponseEntity.ok(companyService.findAllCompanies());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyEntity> findCompanyById(@PathVariable Long id) {
        CompanyEntity company = companyService.findCompanyById(id);
        if (company != null) {
            return new ResponseEntity<>(company, HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping()
    public ResponseEntity<String> addCompany (@RequestBody CompanyEntity company){
        companyService.addCompany(company);
        return new ResponseEntity<>("Company Added To DB", HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable Long id){
        boolean companyRemoved = companyService.removeCompanyById(id);
        if (companyRemoved) {
            return new ResponseEntity<>("Job Deleted Successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompanyById(@PathVariable Long id, @RequestBody CompanyEntity entity){
        boolean entityUpdated = companyService.updateCompanyById(id, entity);
        if (entityUpdated) {
            return new ResponseEntity<>("Company Info Updated", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("ERROR: No Related Data Found For this ID", HttpStatus.NOT_FOUND);
        }

    }
}
