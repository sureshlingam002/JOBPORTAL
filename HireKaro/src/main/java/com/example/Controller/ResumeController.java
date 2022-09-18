package com.example.Controller;

import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.Beans.Resume;
import com.example.Service.ResumeService;

@Controller
public class ResumeController {

	@Autowired
	ResumeService rservice;
	
	@GetMapping("/uploadResume/{email}")
	public String uploadResumePage(@PathVariable("email")String email, Model model)
	{
		model.addAttribute("email", email);
		return "uploadResume.html";
	}
	
	@PostMapping("/uploaded")
	public String uploadResume(@RequestParam("resume")MultipartFile file, @RequestParam("email")String email) throws IOException
	{
		
		rservice.store(file, email);
		return "resumeuploaded.html";
	}
	
	@GetMapping("/download/{applicantEmail}")
	public void getResume(@PathVariable("applicantEmail") String applicantEmail, HttpServletResponse response) throws IOException
	{
		Resume resume = rservice.getFileByApplicantEmail(applicantEmail);
		
		response.setContentType("application/octet-stream");
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=" + resume.getFileName();
		
		response.setHeader(headerKey, headerValue);
		
		ServletOutputStream outputStream = response.getOutputStream();		
		
		outputStream.write(resume.getData());
		/*
		 * return ResponseEntity.ok()
		 * .contentType(MediaType.parseMediaType(resume.getFileType()))
		 * .header(HttpHeaders.CONTENT_DISPOSITION,"attachment:filename=\""+resume.
		 * getFileName()+"\"") .body(new ByteArrayResource(resume.getData()));
		 */
	
	}
}
