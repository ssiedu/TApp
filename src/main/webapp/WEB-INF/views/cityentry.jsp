<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@page isELIgnored="false" %>
<html>
<body>
	<h3>City-Entry-Form</h3>
	<hr>
		<form:form action="savecity" modelAttribute="city">
		<pre>
			CityName	<form:input path="cityname"/>
			State  .	<form:select path="state" items="${states}"/>
				<input type="submit" value="Save"/>
			</pre>
		</form:form>
	<hr>
	<a href="adminhome">Admin-Home</a><br>
	<a href="index.jsp">Home</a><br>
</body>
</html>