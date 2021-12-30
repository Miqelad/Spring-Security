<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!doctype html>
<html>

<body>
<h3>Information</h3>
<security:authorize access="hasRole('princess')">
<input type="button" value="Salary"
onclick="window.location.href='hr_info'">
Only princess
</security:authorize>
<security:authorize access="hasRole('methodist')">
<input type="button" value="Performance"
       onclick="window.location.href='manger_info'">
Only Methodist
</security:authorize>
</body>
</html>
