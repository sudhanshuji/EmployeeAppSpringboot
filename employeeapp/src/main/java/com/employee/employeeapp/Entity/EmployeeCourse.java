package com.employee.employeeapp.Entity;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class EmployeeCourse {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String status;
	
	@Temporal(TemporalType.DATE)
	private Date startDate;
	
	@Temporal(TemporalType.DATE)
	private Date endDate;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
			
	@JoinColumn(name = "Course_Id")
	private Course course;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Employee_Id")
	private Employee employee;
//	@ManyToOne
//	private List<Course> courses;
//	
//	@ManyToOne
//	private List<Employee> employees;

	public EmployeeCourse() {
	}

	/**
	 * @param id
	 *
	 * @param status
	 * @param startDate
	 * @param endDate
	 * @param course
	 * @param employees
	 */
	public EmployeeCourse(String status, Date startDate, Date endDate, Course course, Employee employee) {
		super();

		this.status = status;
		this.startDate = startDate;
		this.endDate = endDate;
		this.course = course;
		this.employee = employee;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}
