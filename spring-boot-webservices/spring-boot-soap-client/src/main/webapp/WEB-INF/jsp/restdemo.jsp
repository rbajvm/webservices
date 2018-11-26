<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<html lang="en">
<head>
<!-- <style>
table, th, td,tr {
    border: 1px solid black;
}
</style> -->





<script src="https://code.jquery.com/jquery-1.12.4.js"></script>

<script type="text/javascript">
	
	$(document).ready(function(){
		$("#submit").click(function(){
			$('#records_table').html('');
			var data = {}
			data["name"] = $("#name").val();
			data["gender"] = $("#gender").val();
			data["dob"] = $("#dob").val();
			var url="http://localhost:8083/rest/api/agecalculator";
			data=helpers.ajaxhelpers(data,url,"POST");							
			
			
		});
	}
	);
</script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js"
	type="text/javascript"></script>
<script type="text/javascript"
		src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src='http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js'></script>
<script
	src='http://cdnjs.cloudflare.com/ajax/libs/bootstrap-validator/0.4.5/js/bootstrapvalidator.min.js'></script>
<link rel='stylesheet prefetch'
	href='http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css'>
<link rel='stylesheet prefetch'
	href='http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css'>
<link rel='stylesheet prefetch'
	href='http://cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.0/css/bootstrapValidator.min.css'>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<script src='/helper.js'></script>
<c:set var="soapresponse" value="${soapresponse}" />
<body>

	<nav class="navbar navbar-inverse">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">REST Webservice Testing Demo</a>
			</div>
			
	</nav>

	<div class="container">

		<form:form class="well form-horizontal" action="/welcome" method="post" id="contact_form" modelAttribute="agecalc">
			<fieldset>
				<div class="form-group">
					<form:label path="name" class="col-md-4 control-form">Name</form:label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
						<form:input id="name" path="name" name="name"
								placeholder="Enter Name" class="form-control" type="text"/>
						</div>
					</div>
				</div>

				<div class="form-group">
					<form:label path="dob" class="col-md-4 control-form">Date of Birth</form:label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
								<form:input id="dob" path="dob" name="DOB" placeholder="Enter DOB"
									class="form-control" type="date"></form:input>
						</div>
					</div>
				</div>
				<div class="form-group">
						<form:label path="dob" class="col-md-4 control-form">Gender</form:label>
						<div class="col-md-4 inputGroupContainer">
							<div class="input-group">
							<form:select id="gender" class="form-control" path="gender" name="gender" >
							<form:option value="NONE" label="- Please select Project--" />
							<form:options items="${gender}" />
							</form:select>
							</div>
						</div>
					</div>

				<!-- Button -->
				<div class="form-group">
					<div class="col-md-4">
						<input id="submit" value="Submit" class="btn btn-info" type="button">
					</div>
				</div>

			</fieldset>
		</form:form>
<table id = "records_table" class="table">
  </table>
		
		
		
	</div>



</body>

</html>