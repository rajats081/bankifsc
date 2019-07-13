package com.fyle.bankifsc.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;


@Entity
@Table(name = "bankdetail")
public class Bank {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IFSCCode;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "city")
    private String city;

    @NotNull
    @Column(name = "contactnumber")
    private String contactNumber;

    public Bank(String name, Integer IFSCCode, String city, String contactNumber) {
        this.name = name;
        this.IFSCCode = IFSCCode;
        this.city = city;
        this.contactNumber = contactNumber;
    }

    public Bank() {

    }

    public Integer getIFSCCode() {
        return IFSCCode;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bank bank = (Bank) o;
        return Objects.equals(name, bank.name) &&
                Objects.equals(IFSCCode, bank.IFSCCode) &&
                Objects.equals(city, bank.city) &&
                Objects.equals(contactNumber, bank.contactNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, IFSCCode, city, contactNumber);
    }
}