package com.example.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Beans.Applicant;
import com.example.Service.ApplicantAndCompanyService;
import com.example.UserRepository.ApplicantRepository;


@Controller
public class ApplicantController {
	
	@Autowired
	ApplicantRepository urepo;
	
	@Autowired
	ApplicantAndCompanyService service;

	
	@GetMapping("/UpdateUser")
	public String userUpdationPage(Model model )
	{	
		model.addAttribute("user", new Applicant());
		return "update_user.html";
	}
	
	@PostMapping("/updateUser")
	public String updateUser(@RequestParam String first_name, @RequestParam String last_name,@RequestParam String email,@RequestParam String password,@RequestParam String gender,@RequestParam int experience,@RequestParam String keySkills,@RequestParam String preferredIndustry )
	{
		service.updateUser(first_name, last_name, email, experience, preferredIndustry, keySkills, password, experience, gender);
		return "profileupdated.html";
	}
	
	@GetMapping("/returnApplicantPage")
	public String returnApplicantPage()
	{
		return "applicant_page.html";
	}
	
	@GetMapping("/forgotPassword")
	public String forgotPasswordPage()
	{
		return "forgotPassword.html";
	}
	
	@PostMapping("/passwordChange")
	public String passwordChange(@RequestParam("email")String email,@RequestParam("answer")String answer,@RequestParam("question")String question,@RequestParam("newPassword")String newPassword) 
	{
		
		
		Applicant userdata = urepo.findByEmail(email);
		
		if(userdata!=null)
		{
			String ques = userdata.getQuestion();
			String ans = userdata.getAnswer();
			if( (question.equals(ques))  && (answer.equals(ans)))
			{
				
				userdata.setPassword(newPassword);
				urepo.save(userdata);
				return "passwordChanged.html";
			}
			else 
			{
				return "home.html";
			}
		}
		
		else
		{
			return "home.html";
		} 
		
	}

	
}
