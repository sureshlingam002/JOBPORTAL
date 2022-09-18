package com.example.UserRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Beans.CompanyUser;

@Repository
public interface CompanyUserRepository extends JpaRepository<CompanyUser, Integer> {
	

	CompanyUser findByCompanyEmail(String email);

	CompanyUser findByCompanyCode(String companyCode);
}
