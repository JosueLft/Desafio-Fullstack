package com.reign.lofty.applicationAPI.resources;

import com.reign.lofty.applicationAPI.entities.Company;
import com.reign.lofty.applicationAPI.entities.suppliers.Supplier;
import com.reign.lofty.applicationAPI.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/companies")
public class CompanyResource {

    @Autowired
    private CompanyService service;

    @GetMapping
    public ResponseEntity<List<?>> findAll() {
        try {
            List<Company> CompanyList = service.findAll();

            return ResponseEntity.ok().body(CompanyList);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(List.of("FIND ALL: " + e.getMessage()));
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findById(@PathVariable String id) {
        try {
            Company Company = service.findById(id);
            return ResponseEntity.ok().body(Company);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("FIND: " + e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody Company company) {
        try {
            Company comp = new Company(company);
            service.insert(comp);
            return ResponseEntity.ok(comp);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("INSERT: " + e.getMessage());
        }
    }

    @PostMapping(value = "/{id}/insert-suppliers")
    public ResponseEntity<?> insertSuppliers(@PathVariable String id, @RequestBody List<Long> supplierIds) {
        try {
            Company comp = service.findById(id);

            comp.getSuppliers().addAll(service.insertSuppliers(comp, supplierIds));
            return ResponseEntity.ok(comp);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("INSERT SUPPLIERS: " + e.getMessage());
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        try {
            service.delete(id);
            return ResponseEntity.ok().body(id);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("DELETE: " + e.getMessage());
        }
    }

    @PostMapping(value = "/update/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody Company company) {
        try {
            service.update(id, company);
            return ResponseEntity.ok(company);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("INSERT: " + e.getMessage());
        }
    }
}