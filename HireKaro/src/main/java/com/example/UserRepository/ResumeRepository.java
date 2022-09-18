package com.example.UserRepository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Beans.Resume;

@Repository
public interface ResumeRepository extends JpaRepository<Resume, String>{

	Optional<Resume> findByEmail(String applicantEmail);
}
