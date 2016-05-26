<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form commandName="contact" action="/Contact/contact/changePwd.do" method="post">

		<form:hidden path="id" />
	odlPwd :<form:password path="password" />
		<br>
	newPwd :<input type="password" name="newPwd">
		<br>
		<input type="submit" value="登陆">

	</form:form>
</body>
</html>