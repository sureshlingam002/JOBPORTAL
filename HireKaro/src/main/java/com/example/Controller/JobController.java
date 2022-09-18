package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.Beans.Job;
import com.example.Beans.TotalApplications;
import com.example.Service.ApplicantAndCompanyService;
import com.example.UserRepository.JobApplicationRepository;
import com.example.UserRepository.JobsRepository;

@Controller
public class JobController {
	
	@Autowired
	ApplicantAndCompanyService service;
	
	@Autowired
	JobApplicationRepository arepo;
	
	@Autowired
	JobsRepository jrepo;
	
	@GetMapping("/jobSearch")
	public String searchJobs(Model model)
	{
		List<Job> listofjobs=service.listAllJobNots();
		model.addAttribute("listofjobs", listofjobs);
		return "joblist.html";
	}
	
	
	@GetMapping("/apply/{jpost}")
	public String applyJob(@PathVariable(name="jpost")String jpost, Model model)
	{
		Job job = jrepo.findByJpost(jpost);
		
		String companyCode = job.getCompanyCode();	
		
		model.addAttribute("jpost", jpost);
		model.addAttribute("companyCode", companyCode);
		
		
		
		return "apply_job.html";
	}
	
	@PostMapping("/savejobapps")
	public String saveJobApplications(@ModelAttribute("application")TotalApplications ta)
	{
		arepo.save(ta);
		return "jobapplied.html";
	}
}
