<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@page isELIgnored="false" %>
<html>
<body>
	<h3>Transporter-Registration-Form</h3>
	<hr>
		<form:form action="savetransporterchanges" modelAttribute="transporter">
		<pre>
			Email		<form:input path="email"/>
			Password	<form:input path="password"/>
			TName		<form:input path="tname"/>
			Address		<form:input path="address"/>
			City		<form:select path="city" items="${cities}"/>
			State		<form:select path="state" items="${states}"/>
			Mobile		<form:input path="mobile"/>
			Phone		<form:input path="phone"/>
				<input type="submit" value="Save-Changes"/>
			</pre>
		</form:form>
	<hr>
	<a href="transporterhome">Home</a>
</body>
</html>