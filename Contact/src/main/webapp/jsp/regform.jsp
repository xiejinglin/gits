<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>regform</title>
<link rel="stylesheet" type="text/css" href="../css/common.css" />
</head>
<body>

	<form:form commandName="contact" action="reg.do" method="post">
			name:
			<form:input path="name" />
		<form:errors cssClass="error" path="name" />
		<br />
    		pwd:
    		<form:input path="password" />
		<form:errors cssClass="error" path="password" />
		<br />
    		sex:
    		<form:radiobutton path="sex" value="男" />男<form:radiobutton
			path="sex" value="女" />女
		<br />
    		birth:
    		<form:input path="birthday" />
		<form:errors cssClass="error" path="birthday" />
		<br />
    		addr:
    		<form:input path="address" />
		<form:errors cssClass="error" path="address" />
		<br />
		<input type="submit" value="注册" />
	</form:form>




</body>
</html>