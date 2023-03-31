package com.reign.lofty.applicationAPI.entities.suppliers;

import com.reign.lofty.applicationAPI.entities.DTO.SupplierDTO;
import com.reign.lofty.applicationAPI.utils.UUIDGenerator;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(value = "J")
public class LegalPerson extends Supplier {

    @Column(unique = true)
    private long cnpj;

    public LegalPerson() {}

    public LegalPerson(SupplierDTO supplierDTO) {
        super(supplierDTO.getName(), supplierDTO.getEmail(), supplierDTO.getCep(), supplierDTO.getSupplierType());

        if(supplierDTO.getId() == null) {
            this.setId(String.valueOf(UUIDGenerator.generateID()));
        } else {
            this.setId(supplierDTO.getId());
        }

        this.cnpj = supplierDTO.getCnpj();
    }

    public LegalPerson(String name, String email, String CEP, Integer supplierType, long cnpj) {
        super(name, email, CEP, supplierType);
        this.cnpj = cnpj;
    }

    public long getCnpj() {
        return cnpj;
    }
    public void setCnpj(long cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public String toString() {
        return "{\n" +
                "id:" + getId() + ",\n" +
                "name:" + getName() + ",\n" +
                "email:" + getEmail() + ",\n" +
                "CEP:" + getCEP() + ",\n" +
                "SupplierType:" + getSupplierType() + ",\n" +
                "CPF:" + cnpj + "\n" +
                "}";
    }
}