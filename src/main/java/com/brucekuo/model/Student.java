package com.brucekuo.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 * @author Bruce Kuo
 *
 */
@Entity
@Table(name="STUDENT")
public class Student{ 

	@Override
	public int hashCode() {
		return Objects.hash(emailAddress, firstName, id, lastName, phone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Student)) {
			return false;
		}
		Student other = (Student) obj;
		return Objects.equals(emailAddress, other.emailAddress) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(id, other.id) && Objects.equals(lastName, other.lastName)
				&& Objects.equals(phone, other.phone);
	}

	public Student() {
	}

	public Student(Integer id, String firstName, String lastName, String emailAddress, String phone) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.phone = phone;
	}

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	//@NotBlank
	@Pattern(regexp="[a-zA-Z]+", message="First name is required and must be alphabetical")
	private String firstName;
	
	//@NotBlank
	@Pattern(regexp="[a-zA-Z]+",message="Last name is required and must be alphabetical")
	private String lastName;
	
	@Email
	@Pattern(regexp=".+@.+\\..+", message="Please provide a valid email address")
	private String emailAddress;
	
	private String phone;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", emailAddress="
				+ emailAddress + ", phone=" + phone + "]";
	}
	
}
