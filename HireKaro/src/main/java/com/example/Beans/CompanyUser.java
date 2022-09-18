package com.example.Beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CompanyUsers")
public class CompanyUser {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int companyId;
	
	private String companyCode;
	
	@Column(unique= true ,nullable = true,length = 45)
	private String companyEmail;
	
	@Column(nullable = true, length = 45)
	private String companyName;
	
	@Column(nullable = true, length = 100)
	private String companyWebsite;
	
	@Column(nullable = true, length = 45)
	private String companyUserPassword;

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getCompanyEmail() {
		return companyEmail;
	}

	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyWebsite() {
		return companyWebsite;
	}

	public void setCompanyWebsite(String companyWebsite) {
		this.companyWebsite = companyWebsite;
	}

	public String getCompanyUserPassword() {
		return companyUserPassword;
	}

	public void setCompanyUserPassword(String companyUserPassword) {
		this.companyUserPassword = companyUserPassword;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	
	
}
