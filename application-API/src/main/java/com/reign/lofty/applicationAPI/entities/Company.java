package com.reign.lofty.applicationAPI.entities;

import com.reign.lofty.applicationAPI.entities.suppliers.Supplier;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Companies")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String CNPJ;
    private String tradingName;
    private String CEP;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "company_supplier", joinColumns = @JoinColumn(name = "company_id"), inverseJoinColumns = @JoinColumn(name = "supplier_id"))
    private List<Supplier> suppliers = new ArrayList<>();

    public Company() {}

    public Company(Company company) {
        this.CNPJ = company.getCNPJ();
        this.tradingName = company.getTradingName();
        this.CEP = company.getCEP();
    }

    public Company(Long id, String CNPJ, String tradingName, String CEP) {
        if(id != null) {
            this.setId(id);
        }

        this.CNPJ = CNPJ;
        this.tradingName = tradingName;
        this.CEP = CEP;
    }

    public Company(String CNPJ, String tradingName, String CEP) {
        this.CNPJ = CNPJ;
        this.tradingName = tradingName;
        this.CEP = CEP;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getCNPJ() {
        return CNPJ;
    }
    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }
    public String getTradingName() {
        return tradingName;
    }
    public void setTradingName(String tradingName) {
        this.tradingName = tradingName;
    }
    public String getCEP() {
        return CEP;
    }
    public void setCEP(String CEP) {
        this.CEP = CEP;
    }
    public List<Supplier> getSuppliers() {
        return suppliers;
    }

    @Override
    public String toString() {
        return "{\n" +
                "id:" + id + ",\n" +
                "CNPJ:" + CNPJ + ",\n" +
                "tradingName:" + tradingName + ",\n" +
                "CEP:" + CEP + ",\n" +
                "Suppliers:" + suppliers + "\n" +
                "}";
    }
}