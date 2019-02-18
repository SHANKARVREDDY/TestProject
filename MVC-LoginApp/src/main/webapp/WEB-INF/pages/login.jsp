<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1 style='color:blue;text-align:center'>Login Application</h1><br>
<span style='color:red'>
<form:errors path="*"/><br>
</span>
<br>
<form:form method="POST" modelAttribute="userCmd">
UserName:::<form:input path="username"/><br>
Password::<form:password path="pwd"/><br>
Domains::<form:checkboxes items="${domains}" path="dmn"/><br>
Date of Birth::<form:input path="date" />(dd-MM-yyyy)<br>
<input type="submit" value="login">
</form:form>

<br>
<c:if test="${result ne null }">
<c:out value="${result}"/>
</c:if>
<c:out value="${userCmd.date}"/>