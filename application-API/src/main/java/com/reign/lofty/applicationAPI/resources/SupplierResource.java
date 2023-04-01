package com.reign.lofty.applicationAPI.resources;

import com.reign.lofty.applicationAPI.entities.DTO.SupplierDTO;
import com.reign.lofty.applicationAPI.entities.suppliers.LegalPerson;
import com.reign.lofty.applicationAPI.entities.suppliers.NaturalPerson;
import com.reign.lofty.applicationAPI.entities.suppliers.Supplier;
import com.reign.lofty.applicationAPI.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/suppliers")
public class SupplierResource {

    @Autowired
    private SupplierService service;

    @GetMapping
    public ResponseEntity<List<?>> findAll() {
        try {
            List<Supplier> supplierList = service.findAll();

            return ResponseEntity.ok().body(supplierList);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(List.of("FIND ALL: " + e.getMessage()));
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findById(@PathVariable String id) {
        try {
            Supplier supplier = service.findById(id);
            return ResponseEntity.ok().body(supplier);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("FIND: " + e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody SupplierDTO supplierDTO) {
        try {
            Supplier supplier;
            System.err.println(supplierDTO);
            switch (supplierDTO.getSupplierType()) {
                case 0:
                    supplier = new NaturalPerson(supplierDTO);
                    break;
                case 1:
                    supplier = new LegalPerson(supplierDTO);
                    break;
                default:
                    return ResponseEntity.badRequest().body("Invalid user type!");
            }
            service.insert(supplier);
            return ResponseEntity.ok(supplier);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("INSERT: " + e.getMessage());
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
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody SupplierDTO supplierDTO) {
        try {
            Supplier supplier;
            switch (supplierDTO.getSupplierType()) {
                case 0:
                    supplier = new NaturalPerson(supplierDTO);
                    break;
                case 1:
                    supplier = new LegalPerson(supplierDTO);
                    break;
                default:
                    return ResponseEntity.badRequest().body("Invalid user type!");
            }
            supplier = service.update(id, supplier);
            return ResponseEntity.ok(supplier);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("INSERT: " + e.getMessage());
        }
    }
}