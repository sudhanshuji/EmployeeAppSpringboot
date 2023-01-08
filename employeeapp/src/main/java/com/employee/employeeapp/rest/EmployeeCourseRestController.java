package com.employee.employeeapp.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.employeeapp.Entity.Course;
import com.employee.employeeapp.Entity.Employee;
import com.employee.employeeapp.Entity.EmployeeCourse;
import com.employee.employeeapp.dto.EmployeeCourseDto;
import com.employee.employeeapp.dto.ResponseDto;
import com.employee.employeeapp.service.EmployeeCourseService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class EmployeeCourseRestController {

	private EmployeeCourseService employeeCourseService;

	@Autowired
	public EmployeeCourseRestController(EmployeeCourseService theEmployeeCourseService) {
		employeeCourseService = theEmployeeCourseService;
	}

	// expose "/employees" and return list of employees
	@GetMapping("/employees")
	public List<Employee> findAllEmployees() {
		return employeeCourseService.findAll();
	}

	// expose "/courses" and return list of courses
	@GetMapping("/courses")
	public List<Course> findAllCourses() {
		return employeeCourseService.getAllCourse();
	}

	@GetMapping("/employeeCourses")
	public List<EmployeeCourse> getEmployeeCourses() {
		return employeeCourseService.getAllAssignedCourse();
	}

	// add mapping for GET /employee/{employeeId}

	@GetMapping("/employee/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		Employee theEmployee = employeeCourseService.getEmployeeByEmployeeId(employeeId);

		if (theEmployee == null) {
			throw new RuntimeException("Employee id  not found " + employeeId);

		}
		return theEmployee;
	}

	@GetMapping("/courses/{domain}")
	public List<Course> getCourses(@PathVariable String domain) {
		List<Course> theCourse = employeeCourseService.getCourseByDomain(domain);
		if (theCourse == null) {
			throw new RuntimeException("domain  not found " + domain);

		}
		return theCourse;
	}

	// add mapping for GET /course/{courseId}
	@GetMapping("/course/{courseId}")
	public Course getCourse(@PathVariable int courseId) {
		Course theCourse = employeeCourseService.getCourseByCourseId(courseId);

		if (theCourse == null) {
			throw new RuntimeException("Employee id  not found " + courseId);

		}
		return theCourse;
	}

	// add mapping for POST /employeecourse
	@PostMapping("/employeecourse")
	public EmployeeCourse assignCourse(@RequestBody EmployeeCourse employeecourse) {
		employeeCourseService.assignCourseToEmployee(employeecourse);
		return employeecourse;
	}

	// register mapping for POST /employeecourse
	@PostMapping("/employeecoursedto")
	public ResponseDto assignCourse(@RequestBody EmployeeCourseDto employeecoursedto) {
		System.out.println("Request data is in post method function");
		System.out.println(employeecoursedto.toString());
		ResponseDto responseDto = new ResponseDto();
		responseDto.setId("employee.app.api.assignCourse");
		Optional<EmployeeCourse> theEmployeeCourse = null;
		List<String> errors = new ArrayList<>();
		try {
			theEmployeeCourse = Optional.of(employeeCourseService.registerForCourse(employeecoursedto));
			if (null != theEmployeeCourse)
				responseDto.setData("Course assigned successfully");
		} catch (Exception e) {
			errors.add(e.getLocalizedMessage());
		}
		responseDto.setErrors(errors);
		return responseDto;

	}

	@PostMapping("/course")
	public Course addCourse(@RequestBody Course course) {
		employeeCourseService.addCourse(course);
		return course;

	}

	@PostMapping("/employee")
	public Employee addEmployee(@RequestBody Employee employee) {
		employeeCourseService.save(employee);
		return employee;

	}

	@GetMapping("/domains")
	public Set<String> findAllDomains() {
		System.out.println("Request received from client");
		Set<String> set = employeeCourseService.getAllDomains();
		System.out.println(set.toString());
		return set;
	}

	@GetMapping("/employeeCourseAssigned")
	public List<EmployeeCourseDto> getEmployeeCourseAssigned() {
		return employeeCourseService.findAllRegisteredCourse();
	}

}
