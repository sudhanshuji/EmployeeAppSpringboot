package com.employee.employeeapp.dao;

import java.util.List;

import com.employee.employeeapp.Entity.Employee;
import com.employee.employeeapp.dto.EmployeeCourseDto;
import com.employee.employeeapp.exception.DaoException;
import com.employee.employeeapp.exception.ManagerException;

public interface EmployeeDao {
	public List<Employee> findAll();

	public Employee getEmployeeByEmployeeId(int empId) throws DaoException;

	public void save(Employee theEmployee);

	public void deleteById(int theId);
	
//	public boolean registerForCourse(EmployeeCourseDto empCourse) throws ManagerException;
}
