package com.example.UserRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.Beans.TotalApplications;


public interface JobApplicationRepository extends JpaRepository<TotalApplications, Integer> {

	List<TotalApplications> findByCompanyCode(String companyCode);

	
	/*
	 * @Query("SELECT t FROM TotalApplications t WHERE t.companyEmail = 'companyEmail'"
	 * ) public List<TotalApplications> findByCompanyEmail(String companyEmail);
	 */

	//public List<TotalApplications> findAll(String companyEmail);
	
	
	/*
	 * CompanyUser findByCompanyEmail(String companyEmail);
	 * 
	 * @Query("SELECT t FROM TotalApplications t WHERE t.companyCode = ?1")
	 * List<TotalApplications> findAllByCompanyCode(String companyCode);
	 */
	
}
