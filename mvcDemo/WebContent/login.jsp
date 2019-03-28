<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String userName = null;
		String userPass = null;
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if ("name".equals(cookie.getName())) {//找到name为name的cookie值
					userName = cookie.getValue();//将value赋给变量
				}
				if ("pass".equals(cookie.getName())) {//找到name为pass的cookie值
					userPass = cookie.getValue();//将value赋给变量
				}
			}
			if (userName != null && userPass != null) {
				request.getRequestDispatcher("LoginServlet?name=" + userName + "&pass=" + userPass).forward(request,
						response);
			}
		}
	%>
	
	<%
		if (request.getAttribute("message") != null) {
	%>
	<%=request.getAttribute("message")%>
	<%
		}
	%>
	<form action="/mvcDemo/LoginServlet" id="f1" method="post">
		<input type="text" name="name" id="name"><br> <input
			type="text" name="pass" id="pass"><br> <select
			name="timelength">
			<option value="0"></option>
			<option value="1">一天</option>
			<option value="3">三天</option>
			<option value="7">一周</option>
		</select><br> <input type="submit">

	</form>
</body>
</html>