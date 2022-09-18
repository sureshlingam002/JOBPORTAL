package com.example.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.Beans.Job;
import com.example.Beans.TotalApplications;
import com.example.Beans.Applicant;
import com.example.Beans.CompanyUser;
import com.example.UserRepository.JobApplicationRepository;
import com.example.UserRepository.JobsRepository;
import com.example.UserRepository.ApplicantRepository;
import com.example.UserRepository.CompanyUserRepository;

@Service
public class ApplicantAndCompanyService {
	
	@Autowired
	JobsRepository jrep;
	
	@Autowired
	JobApplicationRepository arepo;
	
	@Autowired
	ApplicantRepository urepo;
	
	@Autowired
	CompanyUserRepository crepo;
	
	public List<Job> listAllJobs(String companyCode)
	{
		List<Job> list = jrep.findByCompanyCode(companyCode);
		return list;
	}
	
	public Job listJob(int jobId)
	{
		Job job= jrep.getById(jobId);
		return job;
	}
	
	public List<TotalApplications> listAllApplications(String companyCode)
	{
		
		List<TotalApplications> list1 = arepo.findByCompanyCode(companyCode);		
		return list1;
	
		/*
		 * CompanyUser userdata = arepo.findByCompanyEmail(companyEmail);
		 * 
		 * String companyCode = userdata.getCompanyCode();
		 * 
		 * List<TotalApplications> list= arepo.findAllByCompanyCode(companyCode);
		 */
	
	}
	
	public List<TotalApplications> listAllJobsApps()
	{
		List<TotalApplications> list= arepo.findAll();
		return list;
	}
	
	public void deleteapp(int id)
	{
		arepo.deleteById(id);
	}
	
	public List<Applicant> listAllUsers()
	{
		List<Applicant> list= urepo.findAll();
		return list;
	}
	
	public List<CompanyUser> listAllRecruiters()
	{
		List<CompanyUser> recruiterlist = crepo.findAll();
		return recruiterlist;
	}
	
	public void deleteUser(int id)
	{
		urepo.deleteById(id);
	}
	
	public void deleteRecruiter(int id)
	{
		crepo.deleteById(id);
	}
	
	public void delete(int jobId)
	{
		jrep.deleteById(jobId);
	}
	
	public void updateJob(Job job)
	{
		String mailId = job.getCompanyEmail();
		
		Job job1 = jrep.findByCompanyEmail(mailId);
		
		job1.setLoc(job.getLoc());
		job1.setFarea(job.getFarea());
		job1.setJpost(job.getJpost());
		job1.setVacancy(job.getVacancy());
		job1.setSkills(job.getSkills());
		job1.setSalary(job.getSalary());
		job1.setiDate(job.getiDate());
		job1.setiTime(job.getiTime());
		job1.setiPlace(job.getiPlace());
		job1.setCompany(job.getCompany());
		
		jrep.save(job1);
	
	}


	public void updateUser(String first_name, String last_name, String email, int experience, String preferredIndustry,
			String keySkills, String password, int experience2, String gender) {
		
		Applicant user1= urepo.findByEmail(email);
		user1.setEmail(email);
		user1.setExperience(experience);
		user1.setFirst_name(first_name);
		user1.setPassword(password);
		user1.setLast_name(last_name);
		user1.setKeySkills(keySkills);
		user1.setPreferredIndustry(preferredIndustry);
		user1.setGender(gender);
		
		urepo.save(user1);
	}

	public List<Job> listAllJobNots() {
		List<Job> list = jrep.findAll();
		return list;
	}
}
