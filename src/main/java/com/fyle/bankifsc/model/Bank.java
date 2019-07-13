package com.fyle.bankifsc.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;


@Entity
@Table(name = "bank")
public class Bank {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @NotNull
    @Column(name = "name")
    private String name;
    
    public Bank(int id, @NotNull String name) {
		super();
		Id = id;
		this.name = name;
	}

	public Bank() {

    }

    public String getName() {
        return name;
    }
    
    public int getId() {
        return Id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bank bank = (Bank) o;
        return Objects.equals(name, bank.name) &&
                Objects.equals(Id, bank.Id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, name);
    }
}