package com.reign.lofty.applicationAPI.entities.suppliers;

import jakarta.persistence.*;

@Entity
@Table(name = "Suppliers")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "supplier_type", length = 1, discriminatorType = DiscriminatorType.STRING)
public abstract class Supplier {

    @Id
    private String id;
    private String name;
    private String email;
    private String CEP;

    public Supplier() {}

    public Supplier(String name, String email, String CEP) {
        this.name = name;
        this.email = email;
        this.CEP = CEP;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
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
    public String getCEP() {
        return CEP;
    }
    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    @Override
    public String toString() {
        return "{\n" +
                "id:" + id + ",\n" +
                "name:" + name + ",\n" +
                "email:" + email + ",\n" +
                "CEP:" + CEP + "\n" +
                "}";
    }
}