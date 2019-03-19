package com.ex.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

	@Entity
	@Table(name="ersusers")
	public class User {

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="USER_ID")
		private int userId;

		@Column(name="EMAIL", unique=true)
		private String email;
		
		@Column(name="PASSWORD")
		private String password;
		
		@Column(name="FIRST_NAME")
		private String firstname;
		
		@Column(name="LAST_NAME")
		private String lastname;
		
		@Column(name="ROLE")
		private String role;
		
		
		public User () {
			
		}

		public int getId() {
			return userId;
		}

		public void setId(int userId) {
			this.userId = userId;
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

		public String getFirstname() {
			return firstname;
		}

		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}

		public String getLastname() {
			return lastname;
		}

		public void setLastname(String lastname) {
			this.lastname = lastname;
		}

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}

		@Override
		public String toString() {
			return "User [userId=" + userId + ", email=" + email + ", password=" + password + ", firstname=" + firstname
					+ ", lastname=" + lastname + ", role=" + role + "]";
		}
		
	


	
}
