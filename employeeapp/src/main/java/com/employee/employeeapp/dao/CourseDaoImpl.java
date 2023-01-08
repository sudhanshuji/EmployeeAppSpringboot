package com.employee.employeeapp.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.MutationQuery;
import org.hibernate.query.Query;
import org.hibernate.query.SelectionQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.employee.employeeapp.Entity.Course;
import com.employee.employeeapp.Entity.EmployeeCourse;
import com.employee.employeeapp.exception.DaoException;

import jakarta.persistence.EntityManager;

@Repository
public class CourseDaoImpl implements CourseDao {

	@Autowired
	EntityManager entityManager;

	@Override
	public void deleteCourse(int courseId) throws DaoException {
		// get the current session hibernate
		Session currentSession = entityManager.unwrap(Session.class);

		// delete employee
		MutationQuery theQuery = currentSession.createMutationQuery("" + "delete from Employee where id = :employeeId");
		theQuery.setParameter("employeeId", courseId);
		theQuery.executeUpdate();

	}

	@Override
	public List<Course> getAllCourse() throws DaoException {
		// get the current bhibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		// create query
		Query<Course> theQuery = currentSession.createQuery("from Course", Course.class);

		// execute query and get the result list
		List<Course> courses = theQuery.getResultList();
		// return the result
		return courses;

	}

	@Override
	public boolean assignCourseToEmployee(EmployeeCourse empCourse) throws DaoException {

		Session currentSession = entityManager.unwrap(Session.class);

		currentSession.merge(empCourse);

		// Hibernate returns the generated Id after save
		Integer generatedId = empCourse.getCourse().getCourseId();

		return true;

	}

	@Override
	public List<Course> getAllCourseByDomain(String domain) throws DaoException {

		Session session = null;
		try {
			session = HibernateUtil.getHibernateSession();
		} catch (Exception e1) { // TODO Auto-generated catch block
			e1.printStackTrace();
		}

		String fetchCourseByDomain = "From Course course where course.domain = " + domain;

		try {

			Query<Course> query = session.createQuery(fetchCourseByDomain, Course.class);
			return query.list();

		} catch (HibernateException e) {

			e.printStackTrace();

			throw new DaoException("There was an error while fetching Course by domain\n " + domain, e);

		} finally {

			session.clear();
			session.close();

		}

	}

	@Override
	public Course getCourseByCourseId(int courseId) throws DaoException {
		// get the current hibernate session

		Session currentSession = entityManager.unwrap(Session.class);

		// get the employee
		Course theCourse = currentSession.get(Course.class, courseId);

		// return the employee
		return theCourse;
	}

	@Override
	public void addCourse(Course course) throws DaoException {
		// get the current session hibernate
		Session currentSession = entityManager.unwrap(Session.class);

		// save employee
		currentSession.persist(course);
	}

	@Override
	public List<Course> getCoursesByDomain(String domain) {
		Session currentSession = entityManager.unwrap(Session.class);

//		SelectionQuery<Course> theCourseQuery = currentSession.createQuery("From Course course where course.domain = " + domain, Course.class);
		SelectionQuery<Course> theCourseQuery = currentSession
				.createSelectionQuery("SELECT c FROM Course c WHERE c.domain = :domain", Course.class);
		theCourseQuery.setParameter("domain", domain);

		// Query<Course> theCourseQuery = currentSession.createQuery("From Course course
		// where course.domain = " + domain, Course.class);

		List<Course> courses = theCourseQuery.getResultList();

		return courses;

	}

	@Override
	public Set<String> getCourseDomains() {
		Set<String> domains = new HashSet<>();
		Session currentSession = entityManager.unwrap(Session.class);

		SelectionQuery<String> theDomains = currentSession.createSelectionQuery("SELECT c.domain FROM Course c",
				String.class);

		List<String> fetchedDomain = theDomains.getResultList();

		domains.addAll(fetchedDomain);

		return domains;
	}

}
