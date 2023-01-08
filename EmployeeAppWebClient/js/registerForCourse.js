
var fetchDomainUrl = "http://localhost:8080/api/domains";

var fetchCourseUrl = "http://localhost:8080/api/courses/";

var assignCourseUrl = "http://localhost:8080/api/employeecoursedto";

function fetchDomains(){
	
	document.getElementById("domains_space").innerHTML = "<font color='BLUE'> Domains are on the way</font>";
	
	$.get(fetchDomainUrl, function(data) {

		console.log(data);
		
		var dataTr = "<select name='domain' id='domain' onchange='fetchCoursesByDomain()'>";
		dataTr += "<option value='--**-' >--DOMAIN NAME--</option>";
		data.forEach(function(domain) {
    // code
	
		dataTr += "<option value='"+domain+"'>"+domain+"</option>";
	
		});
		
		dataTr += "</select>"
		
		document.getElementById("domains_space").innerHTML = dataTr	;

	});
	
}

function fetchCoursesByDomain() {
	document.getElementById("courses_space").innerHTML = "<font color='orange'> Courses are on the way</font>";
	//var method = "GET";
	var domain = document.getElementById("domain").value;

	var domain1 = $('#domain').value;
	console.log(domain1);
	
	var finalUrl = fetchCourseUrl + domain;
	
	$.get(finalUrl, function(data) {

		console.log(data);
		
		var dataTr = "<select name='courseId' id='courseId'>";
		
		dataTr += "<option value='' >----COURSE NAME, DURATION---</option>";
		
		data.forEach(function(course) {
    // code
	
		dataTr += "<option value='"+course.courseId+"'>"+course.courseName+", "+course.duration+"</option>";
	
		});
		
		dataTr += "</select>"
		
		
		
		

		document.getElementById("courses_space").innerHTML = dataTr	;

	});
}


function assignCourseToEmployee(){
	alert("Hello!");
	var empId = document.getElementById("empId").value;
	var courseId = document.getElementById("courseId").value;
	var courseStatus = document.getElementById("status").value;
	console.log(empId)
	console.log(courseId)
	console.log(courseStatus)
	var postDataToSend = {courseStatus: courseStatus, courseId: courseId,empId: empId};
	console.log(postDataToSend);
	 $.ajax({
		type: "POST",
		url: assignCourseUrl, 
		contentType: "application/json",
		dataType: "json",
		data: JSON.stringify(postDataToSend),
		success: function(data) {
			console.log(data);
			//alert("Course Registered);
		}, 
		
		error: function(data) {
			console.log(data);
			//alert("Some error, please check logs or console for more detail");
		}, 
		complete: function() {}
	  }); 
}