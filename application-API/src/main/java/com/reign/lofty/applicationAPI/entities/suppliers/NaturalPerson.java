package com.reign.lofty.applicationAPI.entities.suppliers;

import com.reign.lofty.applicationAPI.entities.DTO.SupplierDTO;
import jakarta.persistence.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@DiscriminatorValue(value = "F")
public class NaturalPerson extends Supplier {

    @Column(unique = true)
    private long cpf;
    private String rg;
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    public NaturalPerson() {}

    public NaturalPerson(SupplierDTO supplierDTO) {
        super(supplierDTO.getName(), supplierDTO.getEmail(), supplierDTO.getCep(), supplierDTO.getSupplierType());

        if(supplierDTO.getId() != null) {
            this.setId(supplierDTO.getId());
        }

        this.cpf = supplierDTO.getCpf();
        this.rg = supplierDTO.getRg();
        setBirthDate(supplierDTO.getBirthDate());
    }

    public NaturalPerson(String name, String email, String CEP, Integer supplierType, long cpf, String rg, String birthDate) {
        super(name, email, CEP, supplierType);
        this.cpf = cpf;
        this.rg = rg;
        setBirthDate(birthDate);
    }

    public long getCpf() {
        return cpf;
    }
    public void setCpf(long cpf) {
        this.cpf = cpf;
    }
    public String getRg() {
        return rg;
    }
    public void setRg(String rg) {
        this.rg = rg;
    }
    public String getBirthDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(this.birthDate);
    }
    public void setBirthDate(String birthDate) {
        try {
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            this.birthDate = formatter.parse(birthDate);
        } catch (Exception e) {
            System.err.println("Date Parse: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "{\n" +
                "id:" + getId() + ",\n" +
                "name:" + getName() + ",\n" +
                "email:" + getEmail() + ",\n" +
                "CEP:" + getCEP() + "\n" +
                "CPF:" + cpf + ",\n" +
                "RG:" + rg + ",\n" +
                "SupplierType:" + getSupplierType() + ",\n" +
                "birthDate:" + birthDate + "\n" +
                "}";
    }
}