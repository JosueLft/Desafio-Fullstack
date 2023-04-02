package com.reign.lofty.applicationAPI.entities.suppliers;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.reign.lofty.applicationAPI.entities.Company;
import com.reign.lofty.applicationAPI.enums.SupplierType;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Suppliers")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "person_type", length = 1, discriminatorType = DiscriminatorType.STRING)
public abstract class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String cep;
    private Integer supplierType;

    @ManyToMany(mappedBy = "suppliers", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JsonIgnore
    private List<Company> services = new ArrayList<>();

    public Supplier() {}

    public Supplier(String name, String email, String cep, Integer supplierType) {
        this.name = name;
        this.email = email;
        this.cep = cep;
        this.supplierType = supplierType;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }
    public Integer getSupplierType() {
        return supplierType;
    }
    public void setSupplierType(SupplierType supplierType) {
        if(supplierType != null) {
            this.supplierType = supplierType.getCode();
        }
    }
    public List<Company> getServices() {
        return services;
    }

    @Override
    public String toString() {
        return "{\n" +
                "id:" + id + ",\n" +
                "name:" + name + ",\n" +
                "email:" + email + ",\n" +
                "CEP:" + cep + "\n" +
                "SupplierType:" + supplierType + ",\n" +
                "Services:" + services + "\n" +
                "}";
    }
}