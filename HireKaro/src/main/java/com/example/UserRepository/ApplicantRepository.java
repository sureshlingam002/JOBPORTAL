package com.example.UserRepository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.Beans.Applicant;

public interface ApplicantRepository extends JpaRepository<Applicant, Integer> {
	
	Applicant findByEmail(String useId);
}
