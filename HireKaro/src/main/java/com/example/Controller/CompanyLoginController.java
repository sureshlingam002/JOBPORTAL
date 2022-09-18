package com.example.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Beans.CompanyUser;
import com.example.UserRepository.CompanyUserRepository;

@Controller
public class CompanyLoginController {
	
	@Autowired(required=true)
	private CompanyUserRepository repo;

	@GetMapping("/companyLoginPage")
	public String ViewCompanyLoginPage()
	{
		return "company_login.html";
	}
	
	@GetMapping("/company_register")
	public String ViewCompanyRegistrationPage(Model model)
	{
		model.addAttribute("companyUsers", new CompanyUser());
		return "company_registration.html";
	}
	
	@PostMapping("/company_register_success")
	public String CompanyRegistrationSuccess(@ModelAttribute("company_user") CompanyUser user)
	{
		
		String mail = user.getCompanyEmail();
		CompanyUser userdata = repo.findByCompanyEmail(mail);
		CompanyUser userdata2 = repo.findByCompanyCode(user.getCompanyCode());
		
		if(userdata!=null || userdata2!=null)
		{
			return "alreadyexist.html";
		}
		else
		{
		repo.save(user);
		return "companyregistersuccess.html";
		}
	}
	
	@GetMapping("/companyregistersuccess")
	public String returnHomePage()
	{
		return "company_login.html";
	}
	
	@RequestMapping("/company_login")
	public String login(@RequestParam("companyEmail")String companyEmail, @RequestParam("companyUserPassword") String companyUserPassword, Model model)
	{
		
		CompanyUser userdata = repo.findByCompanyEmail(companyEmail);
		
		
		if(userdata==null)
		{
			return "invalid.html";
		}
		else 
		{
			String password1=userdata.getCompanyUserPassword();
			String companyCode = userdata.getCompanyCode();
			String companyName = userdata.getCompanyName();
		
			if(password1.equals(companyUserPassword))
			{
				
				model.addAttribute("userdata", userdata);
				model.addAttribute("companyCode", companyCode);
				model.addAttribute("companyName", companyName);
				return "company_homepage.html";
			}
			else
			{
				return "invalid.html";
			}
		}
	
	
	}
	
	
	
	
}
