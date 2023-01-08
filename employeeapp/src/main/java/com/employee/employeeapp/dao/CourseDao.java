package com.employee.employeeapp.dao;

import java.util.List;
import java.util.Set;

import com.employee.employeeapp.Entity.Course;
import com.employee.employeeapp.Entity.EmployeeCourse;
import com.employee.employeeapp.exception.DaoException;

public interface CourseDao {

	public void addCourse(Course course) throws DaoException;

	public void deleteCourse(int CourseId) throws DaoException;

	List<Course> getAllCourse() throws DaoException;

	List<Course> getAllCourseByDomain(String domain) throws DaoException;
	
//	Employee getEmployee

	boolean assignCourseToEmployee(EmployeeCourse empCourse) throws DaoException;

	Course getCourseByCourseId(int courseId) throws DaoException;

	public List<Course> getCoursesByDomain(String domain);

	public Set<String> getCourseDomains();

}
