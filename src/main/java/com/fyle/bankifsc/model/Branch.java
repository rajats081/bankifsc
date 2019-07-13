package com.fyle.bankifsc.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "branch")
public class Branch {
	@Id
	@Column(name = "ifsc")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ifsc;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
	@JoinColumn(name = "bankid")
	private Bank bank;

	@NotNull
	@Column(name = "branch")
	private String branch;

	@NotNull
	@Column(name = "address")
	private String address;

	@NotNull
	@Column(name = "city")
	private String city;

	@NotNull
	@Column(name = "district")
	private String district;

	@NotNull
	@Column(name = "state")
	private String state;

	public Branch(Bank bank, String branch, String address, String city, String district, String state) {
		this.bank = bank;
		this.branch = branch;
		this.address = address;
		this.city = city;
		this.district = district;
		this.state = state;
	}

	public Branch() {
	}

	public int getIfsc() {
		return ifsc;
	}

	public void setIfsc(int ifsc) {
		this.ifsc = ifsc;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Branch branch1 = (Branch) o;
		return getIfsc() == branch1.getIfsc() &&
				Objects.equals(getBank(), branch1.getBank()) &&
				Objects.equals(getBranch(), branch1.getBranch()) &&
				Objects.equals(getAddress(), branch1.getAddress()) &&
				Objects.equals(getCity(), branch1.getCity()) &&
				Objects.equals(getDistrict(), branch1.getDistrict()) &&
				Objects.equals(getState(), branch1.getState());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getIfsc(), getBank(), getBranch(), getAddress(), getCity(), getDistrict(), getState());
	}
}