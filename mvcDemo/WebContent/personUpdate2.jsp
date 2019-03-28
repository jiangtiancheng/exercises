<%@page import="com.tentact.mvcDemo.vo.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%Person person = (Person)request.getAttribute("person"); %>
	<form action="UpdatePersonServlet" method="post">
	名字<input type="text" name="name" value="<%=person.getName() %>"><br>
	密码<input type="text" name="pass" value="<%=person.getPassword() %>"><br>
	<input type="hidden" name="id" value="<%=person.getId()%>">
	<input type="submit" value="修改">
	</form>
</body>
</html>