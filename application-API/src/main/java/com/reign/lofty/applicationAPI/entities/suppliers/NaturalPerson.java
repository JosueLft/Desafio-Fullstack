package com.reign.lofty.applicationAPI.entities.suppliers;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(value = "F")
public class NaturalPerson extends Supplier {

    @Column(unique = true)
    private long CPF;
    private String RG;
    private String birthDate;

    public NaturalPerson() {}

    public NaturalPerson(String name, String email, String CEP, long CPF, String RG, String birthDate) {
        super(name, email, CEP);
        this.CPF = CPF;
        this.RG = RG;
        this.birthDate = birthDate;
    }

    public long getCPF() {
        return CPF;
    }
    public void setCPF(long CPF) {
        this.CPF = CPF;
    }
    public String getRG() {
        return RG;
    }
    public void setRG(String RG) {
        this.RG = RG;
    }
    public String getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "{\n" +
                "id:" + getId() + ",\n" +
                "name:" + getName() + ",\n" +
                "email:" + getEmail() + ",\n" +
                "CEP:" + getCEP() + "\n" +
                "CPF:" + CPF + ",\n" +
                "RG:" + RG + ",\n" +
                "birthDate:" + birthDate + "\n" +
                "}";
    }
}