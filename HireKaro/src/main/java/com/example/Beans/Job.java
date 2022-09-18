package com.example.Beans;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="jobs")
public class Job {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int jobId;
	private String loc;
	private String farea;
	private String jpost;
	private int vacancy;
	private String skills;
	private String salary;
	private String companyCode;
	private String iDate;
	private String iTime;
	private String iPlace;
	private String company;
	private String companyEmail;
	
	
	public String getCompanyEmail() {
		return companyEmail;
	}
	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}
	public int getJobId() {
		return jobId;
	}
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public String getFarea() {
		return farea;
	}
	public void setFarea(String farea) {
		this.farea = farea;
	}
	public String getJpost() {
		return jpost;
	}
	public void setJpost(String jpost) {
		this.jpost = jpost;
	}
	public int getVacancy() {
		return vacancy;
	}
	public void setVacancy(int vacancy) {
		this.vacancy = vacancy;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getiDate() {
		return iDate;
	}
	public void setiDate(String iDate) {
		this.iDate = iDate;
	}
	public String getiTime() {
		return iTime;
	}
	public void setiTime(String iTime) {
		this.iTime = iTime;
	}
	public String getiPlace() {
		return iPlace;
	}
	public void setiPlace(String iPlace) {
		this.iPlace = iPlace;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	
	
	
	
	
}
