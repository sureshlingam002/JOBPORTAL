package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Beans.Job;
import com.example.Beans.TotalApplications;
import com.example.Service.ApplicantAndCompanyService;
import com.example.UserRepository.JobsRepository;

@Controller
public class RecruiterController {
	
	@Autowired
	JobsRepository jrep;
	
	@Autowired
	ApplicantAndCompanyService service;

	@RequestMapping("/addjobs/{companyCode}")
	public String addJobs(Model model, @PathVariable("companyCode")String companyCode)
	{
		model.addAttribute("companyCode", companyCode);
		model.addAttribute("job", new Job());
		return "addjob.html";
	}
	
	@PostMapping("/savejob")
	public String saveJob(@ModelAttribute("job")Job job)
	{
		jrep.save(job);
		return "jobupdated.html";
	}
	
	@GetMapping("/retunAddjob")
	public String returnCompany()
	{
		return "addjob.html";
	}
	
	@GetMapping("/viewandedit/{companyCode}")
	public String viewAndEdit(@PathVariable(name="companyCode")String companyCode, Model model)
	{
		System.out.println(companyCode);
		
		List<Job> listofjobs=service.listAllJobs(companyCode);
		model.addAttribute("listofjobs", listofjobs);
		return "viewandedit.html";
	}
	
	@RequestMapping("/deletejob/{jobId}")
	public String DeleteJob(@PathVariable(name="jobId")int jobId, Model model)
	{
		service.delete(jobId);
		return "viewandedit.html";
	}
	
	@GetMapping("/editjob/{companyCode}")
	public String editJob(Model  model, @PathVariable("companyCode")String companyCode)
	{
		model.addAttribute("companyCode", companyCode);
		return "editjob.html";
	}
	
	@PostMapping("/editedjob")
	public String jobEdited(@ModelAttribute("job")Job job)
	{
		service.updateJob(job);
		return "jobupdated.html";
	}
	
	@GetMapping("/appliedCandidates/{companyCode}")
	public String appliedCandidates(@PathVariable(name="companyCode")String companyCode, Model model)	
	{
		
		List<TotalApplications> listofappstotal = service.listAllApplications(companyCode);
		model.addAttribute("listofappstotal", listofappstotal);
		
		return "applied_jobs.html";
	}
	
	
	
	@RequestMapping("/deletecand/{id}")
	public String deleteCandidate(@PathVariable(name="id")int id)
	{
		service.deleteapp(id);
		return "applied_jobs.html";
	}
	

}
