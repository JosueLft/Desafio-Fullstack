package com.reign.lofty.applicationAPI.services;

import com.reign.lofty.applicationAPI.entities.Company;
import com.reign.lofty.applicationAPI.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository repository;

    public List<Company> findAll() { return repository.findAll(); }

    public Company findById(String id) {
        Optional<Company> Company = repository.findById(id);
        return Company.get();
    }

    public Company insert(Company Company) {
        return repository.save(Company);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }

    public Company update(String id, Company Company) {
        Company entity = repository.getReferenceById(id);
        updateData(entity, Company);
        return entity;
    }

    private void updateData(Company entity, Company company) {
        entity.setCEP(company.getCEP());
        entity.setCNPJ(company.getCNPJ());
        entity.setTradingName(company.getTradingName());
    }
}