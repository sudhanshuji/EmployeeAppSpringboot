package com.employee.employeeapp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.employee.employeeapp.Entity.EmployeeCourse;
import com.employee.employeeapp.dto.EmployeeCourseDto;
import com.employee.employeeapp.exception.DaoException;

import jakarta.persistence.EntityManager;

@Repository
public class EmployeeCourseDaoImpl implements EmployeeCourseDao{

	@Autowired
	private EntityManager entityManager;

	@Override
	public EmployeeCourse assignCourseToEmployee(EmployeeCourse empCourse) throws DaoException {
		// TODO Auto-generated method stub
		Session currentSession = entityManager.unwrap(Session.class);
		return currentSession.merge(empCourse);
	}

	@Override
	public List<EmployeeCourse> getAllAssignedCourseInfo() {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<EmployeeCourse> theQuery = currentSession.createQuery("from EmployeeCourse", EmployeeCourse.class);
		
		List<EmployeeCourse> emplCourses = theQuery.getResultList();
		
		return emplCourses;
		
	}

	@Override
	public EmployeeCourse registerForCourse(EmployeeCourse employeecourse) {
		// TODO Auto-generated method stub
		Session currentSession = entityManager.unwrap(Session.class);
		return currentSession.merge(employeecourse);
	}
	
	@Override
	public List<EmployeeCourseDto> getAllAssignedCourses() {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<EmployeeCourseDto> theQuery = currentSession.createQuery("from EmployeeCourse", EmployeeCourseDto.class);
		
		List<EmployeeCourseDto> emplCourses = theQuery.getResultList();
		
		
		return emplCourses;
		
	}

	

}
