package com.brucekuo.model;


import java.io.Serializable;
import java.util.Objects;

/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 * @author Bruce Kuo
 *
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "COURSE")
public class Course implements Serializable {

	@Override
	public int hashCode() {
		return Objects.hash(credit, description, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Course)) {
			return false;
		}
		Course other = (Course) obj;
		return Objects.equals(credit, other.credit) && Objects.equals(description, other.description)
				&& Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}

	public Course() {
		super();
	}
	
	public Course(Integer id, String name, String description, Integer credit) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.credit = credit;
	}

	private static final long serialVersionUID = 1L;

		@Id
        @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;
        
		@Column(name = "name")
		private String name;
		
		@Column(name = "description")
		private String description;
		
		@Column(name = "credit")
		private Integer credit;

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public Integer getCredit() {
			return credit;
		}

		public void setCredit(Integer credit) {
			this.credit = credit;
		}

		@Override
		public String toString() {
			return "Course [id=" + id + ", name=" + name + ", description=" + description + ", credit=" + credit
					+ "]";
		}





}