package com.ex.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// establishing a table in the database for users and giving it a name and properties 
// using encapsulation (private data known as data-binding / public methods to get and set the values)

	@Entity
	@Table(name="ersuser")
	public class User {

		
		@Column(name="USER_ID")
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int id;
		
		@Id
		@Column(name="EMAIL")
		private String email;
		
		@Column(name="PASSWORD")
		private String password;
		
		@Column(name="FIRST_NAME")
		private String firstname;
		
		@Column(name="LAST_NAME")
		private String lastname;
		
		@Column(name="ROLE")
		private boolean role;
		
		
		public User () {
			
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

		public boolean isRole() {
			return role;
		}

		public void setRole(boolean role) {
			this.role = role;
		}

		@Override
		public String toString() {
			return "User [id=" + id + ", email=" + email + ", password=" + password + ", firstname=" + firstname
					+ ", lastname=" + lastname + ", role=" + role + "]";
		}
		
	


	
}
