package com.example.Service;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.Beans.Resume;
import com.example.UserRepository.ResumeRepository;

@Service
public class ResumeService {

    @Autowired
    private ResumeRepository rrepo;
    
    
    public Resume store(MultipartFile file, String email) throws IOException
    {
    	String fileName = file.getOriginalFilename();
    	Resume resume = new Resume(UUID.randomUUID().toString(), fileName, file.getContentType(),file.getBytes(), email);
    		 	
    	return rrepo.save(resume);
    }
    
    public Resume getFileByApplicantEmail(String applicantEmail)
    {
    	Optional<Resume> resumeOptional = rrepo.findByEmail(applicantEmail);
    	
    	if(resumeOptional.isPresent())
    	{
    		return resumeOptional.get();	
    	}
    	return null;
    }
}