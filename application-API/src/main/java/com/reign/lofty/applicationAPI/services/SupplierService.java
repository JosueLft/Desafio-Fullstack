package com.reign.lofty.applicationAPI.services;

import com.reign.lofty.applicationAPI.entities.suppliers.LegalPerson;
import com.reign.lofty.applicationAPI.entities.suppliers.NaturalPerson;
import com.reign.lofty.applicationAPI.entities.suppliers.Supplier;
import com.reign.lofty.applicationAPI.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository repository;

    public List<Supplier> findAll() { return repository.findAll(); }

    public Supplier findById(String id) {
        Optional<Supplier> supplier = repository.findById(id);
        return supplier.get();
    }

    public Supplier insert(Supplier supplier) {
        return repository.save(supplier);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }

    public Supplier update(String id, Supplier supplier) {
        Supplier entity = findById(id);
        switch (entity.getSupplierType()) {
            case 0:
                NaturalPerson np = (NaturalPerson) repository.getReferenceById(id);
                updateData(np, (NaturalPerson) supplier);
                return repository.save(np);
            case 1:
                LegalPerson lp = (LegalPerson) repository.getReferenceById(id);
                updateData(lp, (LegalPerson) supplier);
                return repository.save(lp);
            default:
                return repository.save(entity);
        }
    }

    private void updateData(NaturalPerson entity, NaturalPerson supplier) {
        System.err.println(supplier.getBirthDate());
        entity.setName(supplier.getName());
        entity.setEmail(supplier.getEmail());
        entity.setCEP(supplier.getCEP());
        entity.setRg(supplier.getRg());
        entity.setCpf(supplier.getCpf());
        entity.setBirthDate(supplier.getBirthDate());
    }

    private void updateData(LegalPerson entity, LegalPerson supplier) {
        entity.setName(supplier.getName());
        entity.setEmail(supplier.getEmail());
        entity.setCEP(supplier.getCEP());
        entity.setCnpj(supplier.getCnpj());
    }
}