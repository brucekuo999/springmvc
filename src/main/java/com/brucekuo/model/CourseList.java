package com.brucekuo.model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

//@XmlRootElement (name=courses)
public class CourseList implements Serializable{

	  private static final long serialVersionUID = 1L;
	   
	  private List<Course> courses = new ArrayList<>();
	 
	  public List<Course> getCourses() {
	    return courses;
	  }
	 
	  public void setCourses(List<Course> courses) {
	    this.courses = courses;
	  }

	@Override
	public String toString() {
		return "CourseList [courses=" + courses + "]";
	}
	 
	}

