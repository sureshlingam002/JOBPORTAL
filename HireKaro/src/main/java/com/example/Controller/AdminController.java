package com.example.Controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Beans.TotalApplications;
import com.example.Beans.Applicant;
import com.example.Beans.CompanyUser;
import com.example.Service.ApplicantAndCompanyService;
import com.example.UserRepository.JobApplicationRepository;

@Controller
public class AdminController {

	@Autowired
	ApplicantAndCompanyService service;
	
	@Autowired
	JobApplicationRepository jrepo;
	

	@GetMapping("/adminVerify")
	public String adminPage(@RequestParam("adminMail")String email, @RequestParam("adminPassword")String password)
	{
		String adminemail = "admin@hirekaro.com";
		String adminpassword= "12345678";
		
		if((adminemail.equals(email)) && (adminpassword.equals(password)))
		{
			return "admin.html";
		}
		else
		{
			return "invalid.html";
		}
	}
	
	
	@GetMapping("/alljobapps")
	public String viewAllJobApplications(Model model)
	{
		List<TotalApplications> listofapps=service.listAllJobsApps();
		model.addAttribute("listofapps", listofapps);
		

		
		return "jobapplication_list.html";
	}
	
	@RequestMapping("/delete/{id}")
	public String DeleteJob(@PathVariable(name="id")int id)
	{
		service.deleteapp(id);
		return "jobapplication_list.html";
	}
	
	@GetMapping("/viewapplicants")
	public String viewAllApplications(Model model)
	{
		List<Applicant> listofusers=service.listAllUsers();
		model.addAttribute("listofusers", listofusers);
		return "userlist.html";
	}
	
	@GetMapping("/viewrecruiters")
	public String viewRecruiters(Model model)
	{
		List<CompanyUser> listofRecruiters=service.listAllRecruiters();
		model.addAttribute("listofRecruiters", listofRecruiters);
		return "recruiterlist.html";
	}
	
	@PostMapping("/deleterecruiter/{companyId}")
	public String deleteRecruiter(@PathVariable(name="companyId")int id)
	{
		service.deleteRecruiter(id);
		return "recruiterlist.html";
	}
	
	@RequestMapping("/deleteuser/{id}")
	public String DeleteUSer(@PathVariable(name="id")int id)
	{
		service.deleteUser(id);
		return "userlist.html";
	}
	
	@GetMapping("/adminLogin")
	public String adminLoginPage()
	{
	return "admin_login.html";	
	}
	


}
