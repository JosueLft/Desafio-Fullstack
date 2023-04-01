package com.reign.lofty.applicationAPI.entities.DTO;

public class SupplierDTO {

    private Long id;
    private String name;
    private String email;
    private String cep;
    private int supplierType;
    private long cnpj;
    private long cpf;
    private String rg;
    private String birthDate;

    public SupplierDTO() {}

    public SupplierDTO(String name, String email, String cep, int supplierType, long cpf, String rg, String birthDate) {
        this.name = name;
        this.email = email;
        this.cep = cep;
        this.supplierType = supplierType;
        this.cpf = cpf;
        this.rg = rg;
        this.birthDate = birthDate;
    }

    public SupplierDTO(String name, String email, String cep, int supplierType, long cnpj) {
        this.name = name;
        this.email = email;
        this.cep = cep;
        this.supplierType = supplierType;
        this.cnpj = cnpj;
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
    public int getSupplierType() {
        return supplierType;
    }
    public void setSupplierType(int supplierType) {
        this.supplierType = supplierType;
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
        return birthDate;
    }
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
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
                "id:" + id + ",\n" +
                "name:" + name + ",\n" +
                "email:" + email + ",\n" +
                "CEP:" + cep + ",\n" +
                "CPF:" + cpf + ",\n" +
                "CNPJ:" + cnpj + ",\n" +
                "RG:" + rg + ",\n" +
                "SupplierType:" + supplierType + ",\n" +
                "birthDate:" + birthDate + "\n" +
                "}";
    }
}