package com.employee.employeeapp.dao;

import java.util.List;

import com.employee.employeeapp.Entity.EmployeeCourse;
import com.employee.employeeapp.dto.EmployeeCourseDto;
import com.employee.employeeapp.exception.DaoException;

public interface EmployeeCourseDao {
	List<EmployeeCourse> getAllAssignedCourseInfo();
	EmployeeCourse assignCourseToEmployee(EmployeeCourse empCourse) throws DaoException;
	EmployeeCourse registerForCourse(EmployeeCourse employeecourse);
	List<EmployeeCourseDto> getAllAssignedCourses();
}
