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
	@JoinColumn(name = "bank_id")
	private Bank bankId;

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

	public int getIfsc() {
		return ifsc;
	}

	public Branch(int ifsc, @NotNull Bank bankId, @NotNull String branch, @NotNull String address, @NotNull String city,
			@NotNull String district, @NotNull String state) {
		super();
		this.ifsc = ifsc;
		this.bankId = bankId;
		this.branch = branch;
		this.address = address;
		this.city = city;
		this.district = district;
		this.state = state;
	}

	public Branch() {

	}

	public void setIfsc(int ifsc) {
		this.ifsc = ifsc;
	}

	public Bank getBankId() {
		return bankId;
	}

	public void setBankId(Bank bankId) {
		this.bankId = bankId;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((bankId == null) ? 0 : bankId.hashCode());
		result = prime * result + ((branch == null) ? 0 : branch.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((district == null) ? 0 : district.hashCode());
		result = prime * result + ifsc;
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Branch other = (Branch) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (bankId == null) {
			if (other.bankId != null)
				return false;
		} else if (!bankId.equals(other.bankId))
			return false;
		if (branch == null) {
			if (other.branch != null)
				return false;
		} else if (!branch.equals(other.branch))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (district == null) {
			if (other.district != null)
				return false;
		} else if (!district.equals(other.district))
			return false;
		if (ifsc != other.ifsc)
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		return true;
	}

}