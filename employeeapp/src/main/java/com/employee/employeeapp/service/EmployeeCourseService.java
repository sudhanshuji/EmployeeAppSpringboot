package com.employee.employeeapp.service;

import java.util.List;
import java.util.Set;

import com.employee.employeeapp.Entity.Course;
import com.employee.employeeapp.Entity.Employee;
import com.employee.employeeapp.Entity.EmployeeCourse;
import com.employee.employeeapp.dto.EmployeeCourseDto;
import com.employee.employeeapp.exception.DaoException;
import com.employee.employeeapp.exception.ManagerException;


public interface EmployeeCourseService {
	public void addCourse(Course course);

	public void deleteCourse(int CourseId);

	public List<Course> getAllCourse();

	public List<Course> getAllCourseByDomain(String domain);
	
	
	public Course getCourseByCourseId(int courseId);

	public List<EmployeeCourse> getAllAssignedCourse();
	//	Employee getEmployee

	EmployeeCourse assignCourseToEmployee(EmployeeCourse empCourse);

//	boolean registerForCourse(EmployeeCourseDto empCourse) throws ManagerException;
	
	//employeeDao
	
	public List<Employee> findAll();

	public Employee getEmployeeByEmployeeId(int empId);

	public void save(Employee theEmployee);

	public void deleteById(int theId);

	public List<Course> getCourseByDomain(String domain);

	public Set<String> getAllDomains();

	public EmployeeCourse registerForCourse(EmployeeCourseDto employeecoursedto);

	public List<EmployeeCourseDto> findAllRegisteredCourse();

	

}
