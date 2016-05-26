<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table border="3" width="80%" align="center">

		<tr>
			<td>id</td>
			<td>name</td>
			<td>sex</td>
			<td>birthday</td>
			<td>address</td>
			<td>Edit</td>
		</tr>

		<c:forEach items="${contacts }" var="contact">

			<tr>
				<td>${contact.id }</td>
				<td>${contact.name }</td>
				<td>${contact.sex }</td>

				<td><fmt:formatDate value="${contact.birthday }" type="date"
						dateStyle="long" /></td>


				<td>${contact.address }</td>
				<td>
					<%-- <a href="update_form/${contact.id }.do">修改</a> --%> <a
					href="contact_delete/${contact.id }.do">删除</a>
				</td>
			</tr>




		</c:forEach>

	</table>

</body>
</html>