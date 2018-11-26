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

<c:set var="soapresponse" value="${soapresponse}" />
<body>

	<nav class="navbar navbar-inverse">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">SOAP Webservice Testing Demo</a>
			</div>
			
	</nav>

	<div class="container">

		<form:form class="well form-horizontal" action="/welcome" method="post" id="contact_form" modelAttribute="agecalc">
			<fieldset>
				<div class="form-group">
					<form:label path="name" class="col-md-4 control-form">Name</form:label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
						<form:input path="name" name="name"
								placeholder="Enter Name" class="form-control" type="text"/>
						</div>
					</div>
				</div>

				<div class="form-group">
					<form:label path="dob" class="col-md-4 control-form">Date of Birth</form:label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
								<form:input  path="dob" name="DOB" placeholder="Enter DOB"
									class="form-control" type="date"></form:input>
						</div>
					</div>
				</div>
				<div class="form-group">
						<form:label path="dob" class="col-md-4 control-form">Gender</form:label>
						<div class="col-md-4 inputGroupContainer">
							<div class="input-group">
							<form:select class="form-control" path="gender" name="gender" >
							<form:option value="NONE" label="- Please select Project--" />
							<form:options items="${gender}" />
							</form:select>
							</div>
						</div>
					</div>

				<!-- Button -->
				<div class="form-group">
					<div class="col-md-4">
						<input id="submit" value="Submit" class="btn btn-info" type="submit">
					</div>
				</div>

			</fieldset>
		</form:form>
		  <table class="table">
    <tbody>
      	<tr>
        <th>Name </th>
        <td>${soapresponse.dataList.name}</td>
        </tr>
        <tr>
        <th>Minor or Major</th>
        <td>${soapresponse.dataList.minmajor}</td>
        </tr>
         <tr>
        <th>Age In Year</th>
        <td>${soapresponse.dataList.ageinyear}</td>
        </tr>
         <tr>
        <th>Age In Months</th>
        <td>${soapresponse.dataList.ageinmonths}</td>
         </tr>
         <tr>
        <th>Age In Weeks</th>
        <td>${soapresponse.dataList.ageinweeks}</td>
        </tr>
        <tr>
        <th>Age In Days</th>
        <td>${soapresponse.dataList.ageindays}</td>
        </tr>
          <tr>
        <th>Age In Hours</th>
         <td>${soapresponse.dataList.ageinhours}</td>
        </tr>
         <tr>
        <th>Age In Minute</th>
        <td>${soapresponse.dataList.ageinminutes}</td>
        </tr>
        <tr>
        <th>Age In Seconds</th>
        <td>${soapresponse.dataList.ageinseconds}</td>
      	</tr>

     
    </tbody>
  </table>
		
		
		
	</div>



</body>

</html>