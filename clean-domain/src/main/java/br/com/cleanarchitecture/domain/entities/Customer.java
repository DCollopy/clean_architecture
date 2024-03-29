package br.com.cleanarchitecture.domain.entities;

import lombok.Data;

import java.util.Set;


@Data
public class Customer extends Profile{

    private String uuid;
    private Functional functional;

    private final String type = "CUSTOMER";
    private Company company;

    private Set<JobOpportunity> jobOpportunities;

    public Customer() {}

    public Customer(String name, String lastName, Email email, Cpf cpf,
                    Phone phone, Functional functional, Company company) {
        super(name, lastName, email, cpf, phone);
        this.functional = functional;
        this.company = company;
    }

    public Customer(String uuid, String name, String lastName, Email email, Cpf cpf,
                    Phone phone, Functional functional) {
        super(name, lastName, email, cpf, phone);
        this.uuid = uuid;
        this.functional = functional;
    }

    public Customer(String name, String lastName, Email email, Cpf cpf,
                    Phone phone, Functional functional) {
        super(name, lastName, email, cpf, phone);
        this.functional = functional;
    }

    public Customer(String uuid,String name, String lastName, Email email, Cpf cpf,
                    Phone phone, Functional functional,Company company) {
        super(name, lastName, email, cpf, phone);
        this.uuid = uuid;
        this.functional = functional;
        this.company = company;
    }

    public Customer(String uuid,String name, String lastName, Email email, Cpf cpf,
                    Phone phone, Functional functional,Company company, Set<JobOpportunity> jobOpportunities) {
        super(name, lastName, email, cpf, phone);
        this.uuid = uuid;
        this.functional = functional;
        this.company = company;
        this.jobOpportunities = jobOpportunities;
    }

    public Customer(Company company) {
        this.company = company;
    }

    public Customer(Set<JobOpportunity> jobOpportunities) {
        this.jobOpportunities = jobOpportunities;
    }

    public String who() {
        return this.getType();
    }

    public String getName() {
        return super.getName();
    }

    public String getLastName() {
        return super.getLastName();
    }

    public Email getEmail() {
        return super.getEmail();
    }

    public Cpf getCpf() {
        return super.getCpf();
    }

    public Phone getPhone() {
        return super.getPhone();
    }

    public Functional getFunctional() {
        return this.functional;
    }

    public Company getCompany() {
        return this.company;
    }

    public String getCompanyCnpj() {
        return this.company.getCnpj();
    }

    public Cnpj getCompanyCnpjObj() {
        return this.company.getCnpjObject();
    }

    public Set<JobOpportunity> getJobOpportunities() {
        return this.jobOpportunities;
    }

    public void setName(String name) {
        super.setName(name);
    }

    public void setLastName(String lastName) {
        super.setLastName(lastName);
    }

    public void setEmail(Email email) {
        super.setEmail(email);
    }

    public void setCpf(Cpf cpf) {
        super.setCpf(cpf);
    }

    public void setPhone(Phone phone) {
        super.setPhone(phone);
    }

    public void setFunctional(Functional functional) {
        this.functional = functional;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setJobOpportunities(Set<JobOpportunity> jobOpportunities) {
        this.jobOpportunities = jobOpportunities;
    }

    public Customer listAll(){
        return this;
    }

    public Customer delete(long id){
        return this;
    }

}
