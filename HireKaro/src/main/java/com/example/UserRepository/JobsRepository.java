package com.example.UserRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Beans.Job;


public interface JobsRepository extends JpaRepository<Job, Integer> {
	
	Job findByCompanyEmail(String mailId);

	Job findByJpost(String jpost);

	List<Job> findByCompanyCode(String companyCode);
	
	
}
