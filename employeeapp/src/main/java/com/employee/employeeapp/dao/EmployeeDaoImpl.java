package com.employee.employeeapp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.MutationQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.employee.employeeapp.Entity.Employee;
import com.employee.employeeapp.exception.DaoException;

import jakarta.persistence.EntityManager;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	
	@Autowired
	private EntityManager entityManager;
	
	/*
	 * @Autowired private CourseDao courseDao;
	 */
	@Override
	public Employee getEmployeeByEmployeeId(int empId) throws DaoException {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Employee theEmployee = currentSession.get(Employee.class, empId);
		
		
		return theEmployee;
	}

	@Override
	public List<Employee> findAll() {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		// create query
		Query<Employee> theQuery = currentSession.createQuery("from Employee", Employee.class);

		// execute query and get the result list
		List<Employee> employees = theQuery.getResultList();
		// return the result
		return employees;

	}
	@Override
	public void save(Employee theEmployee) {
		
		//get the current session hibernate
		Session currentSession = entityManager.unwrap(Session.class);
		
		//save employee
		currentSession.merge(theEmployee);
	}

	@Override
	public void deleteById(int theId) {
		//get the current session hibernate
		Session currentSession = entityManager.unwrap(Session.class);
		
		//delete employee
		MutationQuery theQuery = currentSession.createMutationQuery(""
				+ "delete from Employee where id = :employeeId");
		theQuery.setParameter("employeeId", theId);
		theQuery.executeUpdate();
		
	}
	
	
	/*
	 * @Override public boolean registerForCourse(EmployeeCourseDto empCourseDto)
	 * throws ManagerException { // TODO Auto-generated method stub boolean result =
	 * false;
	 * 
	 * try { Employee employee = getEmployeeByEmployeeId(empCourseDto.getEmpId());
	 * Course course = courseDao.getCourseByCourseId(empCourseDto.getCourseId());
	 * EmployeeCourse empCourse = new EmployeeCourse(empCourseDto.getStatus(), new
	 * Date(), new Date(), course, employee); result =
	 * courseDao.assignCourseToEmployee(empCourse); } catch (DaoException e) { throw
	 * new ManagerException(e); } return result;
	 * 
	 * }
	 */
	

}
