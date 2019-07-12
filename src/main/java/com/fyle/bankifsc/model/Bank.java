package com.fyle.bankifsc.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "bankDetails")
public class Bank {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final String IFSCCode;

    @NotNull
    @Column(name = "name")
    private final String name;

    @NotNull
    @Column(name = "city")
    private final String city;

    @NotNull
    @Column(name = "contactNumber")
    private final String contactNumber;

    public Bank(String name, String IFSCCode, String city, String contactNumber) {
        this.name = name;
        this.IFSCCode = IFSCCode;
        this.city = city;
        this.contactNumber = contactNumber;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
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