package com.example.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Beans.Applicant;
import com.example.UserRepository.ApplicantRepository;

@Controller
public class ApplicantRegistrationAndLoginController {
	
	@Autowired
	ApplicantRepository repo;
	
	
	@GetMapping("/home")
	public String viewHomePage()
	{
		return "home.html";
	}
	
	@GetMapping("/registerUser")
	public String userRegistration(Model model)
	{
		model.addAttribute("user", new Applicant());
		return "registration_page.html";
	}
	
	
	@PostMapping("/process_register")
	public <S> String registrationSuccessfull(@ModelAttribute("user") Applicant user)
	{
		String mail = user.getEmail();
		Applicant userdata = repo.findByEmail(mail);
		
		if(userdata!=null)
		{
			return "alreadyexist.html";
		}
		
		else
		{
		repo.save(user);
		return "register_success.html";
		}
		
	}
	
		
	@GetMapping("/register_success")
	public String returnHomePage()
	{
		return "home.html";
	}
	
	
	
	@PostMapping("/Login")
	public String login(@RequestParam("email")String email, @RequestParam("password") String password, Model model)
	{			
		Applicant userdata = repo.findByEmail(email);
		
		if(userdata==null)
		{
			return "invalid.html";
		}
		
		else
		{
			String password1=userdata.getPassword();
			String mail = userdata.getEmail();
			String name = userdata.getFirst_name();
			
			
			if((mail.equals(email))   &&   (password1.equals(password)))
			{
				model.addAttribute("mail", mail);
				model.addAttribute("name", name);
				return "applicant_page.html";
			}
			
			else
			{
				return "invalid.html";
			}
		}
		
	
	}
	
	
	

	
}
