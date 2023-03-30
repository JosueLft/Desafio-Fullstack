package com.reign.lofty.applicationAPI.entities.suppliers;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(value = "J")
public class LegalPerson extends Supplier {

    @Column(unique = true)
    private long CNPJ;

    public LegalPerson() {}

    public LegalPerson(String name, String email, String CEP, long CNPJ) {
        super(name, email, CEP);
        this.CNPJ = CNPJ;
    }

    public long getCNPJ() {
        return CNPJ;
    }
    public void setCNPJ(long CNPJ) {
        this.CNPJ = CNPJ;
    }

    @Override
    public String toString() {
        return "{\n" +
                "id:" + getId() + ",\n" +
                "name:" + getName() + ",\n" +
                "email:" + getEmail() + ",\n" +
                "CEP:" + getCEP() + "\n" +
                "CPF:" + CNPJ + "\n" +
                "}";
    }
}