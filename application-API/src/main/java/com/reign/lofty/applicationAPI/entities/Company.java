package com.reign.lofty.applicationAPI.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.UniqueConstraint;

@Entity
public class Company {

    @Id
    private String id;
    @Column(unique = true)
    private String CNPJ;
    private String tradingName;
    private String CEP;

    public Company() {}

    public String getId() {
        return id;
    }
    public void setId(String id) {
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

    @Override
    public String toString() {
        return "{\n" +
                "id:" + id + ",\n" +
                "CNPJ:" + CNPJ + ",\n" +
                "tradingName:" + tradingName + ",\n" +
                "CEP:" + CEP + "\n" +
                "}";
    }
}