package com.reign.lofty.applicationAPI.services;

import com.reign.lofty.applicationAPI.entities.Company;
import com.reign.lofty.applicationAPI.entities.suppliers.Supplier;
import com.reign.lofty.applicationAPI.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository repository;

    @Autowired
    private SupplierService supplierService;

    public List<Company> findAll() { return repository.findAll(); }

    public Company findById(String id) {
        Optional<Company> Company = repository.findById(id);
        return Company.get();
    }

    public Company insert(Company Company) {
        return repository.save(Company);
    }

    public List<Supplier> insertSuppliers(Company company, List<Long> suppliersIdsList) {
        List<Supplier> suppliers = new ArrayList<>();

        for (Supplier sup : supplierService.findAll()) {
            for(Long supId : suppliersIdsList) {
                if (sup.getId().equals(supId)) {
                    sup.getServices().add(company);
                    suppliers.add(sup);
                }
            }
        }

        company.getSuppliers().addAll(suppliers);

        repository.save(company);

        return suppliers;
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
        entity.setCep(company.getCep());
        entity.setCnpj(company.getCnpj());
        entity.setTradingName(company.getTradingName());
    }
}