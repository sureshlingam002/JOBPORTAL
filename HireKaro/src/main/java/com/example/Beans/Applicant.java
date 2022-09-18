package com.example.Beans;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="users")
public class Applicant {
		
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int id;
		
		@Column(name="email", nullable = false, unique = true, length = 45)
		private String email;
		

		@Column(length=45)
		private String first_name;
		

		@Column( length=45)
		private String last_name;
		
		@Column(name="password", length = 45)
		private String password;
		
		@Column( length = 45)
		private String gender;
		
		@Column(length = 45)
		private int experience;
		
		@Column( length = 60)
		private String preferredIndustry;
		
		@Column( length = 200)
		private String keySkills;
		
		private String question;
		private String answer;
		
		
		public String getFirst_name() {
			return first_name;
		}


		public void setFirst_name(String first_name) {
			this.first_name = first_name;
		}


		public String getLast_name() {
			return last_name;
		}


		public void setLast_name(String last_name) {
			this.last_name = last_name;
		}


		public String getQuestion() {
			return question;
		}


		public void setQuestion(String question) {
			this.question = question;
		}


		public String getAnswer() {
			return answer;
		}


		public void setAnswer(String answer) {
			this.answer = answer;
		}
		
		public Applicant() {
			super();
		}


		public Applicant(int id, String email, String firstName, String lastName, String password, String gender,
				int experience, String preferredIndustry, String keySkills) {
			super();
			this.id = id;
			this.email = email;
			this.first_name = firstName;
			this.last_name = lastName;
			this.password = password;
			this.gender = gender;
			this.experience = experience;
			this.preferredIndustry = preferredIndustry;
			this.keySkills = keySkills;
		}
		
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public int getExperience() {
			return experience;
		}
		public void setExperience(int experience) {
			this.experience = experience;
		}
		public String getPreferredIndustry() {
			return preferredIndustry;
		}
		public void setPreferredIndustry(String preferredIndustry) {
			this.preferredIndustry = preferredIndustry;
		}
		public String getKeySkills() {
			return keySkills;
		}
		public void setKeySkills(String keySkills) {
			this.keySkills = keySkills;
		}
		
		
		
}
