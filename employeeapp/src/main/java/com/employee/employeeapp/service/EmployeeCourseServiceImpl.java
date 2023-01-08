package com.employee.employeeapp.service;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.employee.employeeapp.Entity.Course;
import com.employee.employeeapp.Entity.Employee;
import com.employee.employeeapp.Entity.EmployeeCourse;
import com.employee.employeeapp.dao.CourseDao;
import com.employee.employeeapp.dao.EmployeeCourseDao;
import com.employee.employeeapp.dao.EmployeeDao;
import com.employee.employeeapp.dto.EmployeeCourseDto;
import com.employee.employeeapp.exception.DaoException;

@Service
public class EmployeeCourseServiceImpl implements EmployeeCourseService {
	@Autowired
	private CourseDao courseDao;

	@Autowired
	private EmployeeDao employeeDao;

	@Autowired
	private EmployeeCourseDao employeeCourseDao;
	
	/*
	 * @Autowired private EmployeeCourseDto employeeCourseDto;
	 */
	@Override
	@Transactional
	public List<Course> getAllCourseByDomain(String domain) {
		// TODO Auto-generated method stub
		try {
			return courseDao.getAllCourseByDomain(domain);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * @Override public boolean registerForCourse(EmployeeCourseDto empCourse)
	 * throws ManagerException { // TODO Auto-generated method stub return false; }
	 * }
	 */

	@Override
	@Transactional
	public void addCourse(Course course) {
		try {
			courseDao.addCourse(course);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	@Transactional
	public void deleteCourse(int CourseId) {
		try {
			courseDao.deleteCourse(CourseId);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	@Transactional
	public List<Course> getAllCourse() {
		try {
			return courseDao.getAllCourse();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@Transactional
	public Course getCourseByCourseId(int courseId) {
		try {
			return courseDao.getCourseByCourseId(courseId);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@Transactional
	public List<Employee> findAll() {
		return employeeDao.findAll();
	}

	@Override
	@Transactional
	public Employee getEmployeeByEmployeeId(int empId) {
		try {
			return employeeDao.getEmployeeByEmployeeId(empId);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@Transactional
	public void save(Employee theEmployee) {
		employeeDao.save(theEmployee);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		employeeDao.deleteById(theId);
	}

	@Override
	@Transactional
	public List<EmployeeCourse> getAllAssignedCourse() {
		return employeeCourseDao.getAllAssignedCourseInfo();
	}

	@Override
	@Transactional
	public EmployeeCourse assignCourseToEmployee(EmployeeCourse empCourse){
		// TODO Auto-generated method stub
		try {
			return employeeCourseDao.assignCourseToEmployee(empCourse);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@Transactional
	public List<Course> getCourseByDomain(String domain) {
		// TODO Auto-generated method stub
		return courseDao.getCoursesByDomain(domain);
	}

	@Override
	@Transactional
	public Set<String> getAllDomains() {
		// TODO Auto-generated method stub
		return courseDao.getCourseDomains();
	}

	@Override
	@Transactional
	public EmployeeCourse registerForCourse(EmployeeCourseDto employeecoursedto) {
		// TODO Auto-generated method stub
		Employee theEmployee = getEmployeeByEmployeeId(employeecoursedto.getEmpId());
		Course theCourse = getCourseByCourseId(employeecoursedto.getCourseId());
		EmployeeCourse theEmployeeCourse = new EmployeeCourse(employeecoursedto.getStatus(), new Date(), new Date(), theCourse, theEmployee);
		EmployeeCourse result =employeeCourseDao.registerForCourse(theEmployeeCourse);
		return result;
	}

	@Override
	@Transactional
	public List<EmployeeCourseDto> findAllRegisteredCourse() {
		// TODO Auto-generated method stub
		return employeeCourseDao.getAllAssignedCourses();
	}

}
