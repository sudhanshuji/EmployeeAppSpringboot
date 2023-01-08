$(document).ready(function(){

	  $.ajax({
		type: "GET",
		url: "http://localhost:8080/api/employees", 
		contentType: "application/json; charset-utf-8",
		dataType: "json",
		success: function(data) {
			console.log(data)
		}, 
		
		error: function(data) {
			console.log(data)
		}, 
		complete: function() {}
	  }); 
	
});