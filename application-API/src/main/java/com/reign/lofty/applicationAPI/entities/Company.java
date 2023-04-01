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
    private long cnpj;
    private String tradingName;
    private String cep;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "company_supplier", joinColumns = @JoinColumn(name = "company_id"), inverseJoinColumns = @JoinColumn(name = "supplier_id"))
    private List<Supplier> suppliers = new ArrayList<>();

    public Company() {}

    public Company(Company company) {
        this.cnpj = company.getCnpj();
        this.tradingName = company.getTradingName();
        this.cep = company.getCep();
    }

    public Company(Long id, long cnpj, String tradingName, String cep) {
        if(id != null) {
            this.setId(id);
        }

        this.cnpj = cnpj;
        this.tradingName = tradingName;
        this.cep = cep;
    }

    public Company(long cnpj, String tradingName, String cep) {
        this.cnpj = cnpj;
        this.tradingName = tradingName;
        this.cep = cep;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public long getCnpj() {
        return cnpj;
    }
    public void setCnpj(long cnpj) {
        this.cnpj = cnpj;
    }
    public String getTradingName() {
        return tradingName;
    }
    public void setTradingName(String tradingName) {
        this.tradingName = tradingName;
    }
    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }
    public List<Supplier> getSuppliers() {
        return suppliers;
    }

    @Override
    public String toString() {
        return "{\n" +
                "id:" + id + ",\n" +
                "CNPJ:" + cnpj + ",\n" +
                "tradingName:" + tradingName + ",\n" +
                "CEP:" + cep + ",\n" +
                "Suppliers:" + suppliers + "\n" +
                "}";
    }
}