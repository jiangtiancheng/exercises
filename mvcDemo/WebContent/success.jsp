<%@page import="com.tentact.mvcDemo.vo.Person"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function del(id){
	if(confirm("是否删除")){
		window.location.href="DeletePersonServlet?pid="+id;
	}
}
function find(){
	var id = document.getElementById("in1").value;
	var form1 = document.getElementById("form1");
	if(id==""){
		form1.action="ShowAllPersonServlet";
	}else{
		form1.action="FindPersonByIdServlet";
	}
	form1.submit();
}
</script>
</head>
<body>
<%=application.getInitParameter("xxx") %>
	<!-- 获得session中的属性 -->
	成功了 欢迎您，<%=session.getAttribute("loginName")%><br>
	<!-- 获得上下文中的属性 -->
   您是第 <%=application.getAttribute("number")%>位登录
	<%
		if (request.getAttribute("msg") != null) {
	%>
	<%=request.getAttribute("msg")%>
	<%
		}
	%>
	<form  id="form1">
	<input type="text" name="id" id="in1"><input type="button" onclick="find()" >
	</form>
	<table border="1">
		<tr>
			<th>编号</th>
			<th>名字</th>
			<th>密码</th>
			<th>状态</th>
			<th>操作</th>
		</tr>
		<%
			if (request.getAttribute("elist") != null) {
				ArrayList<Person> plist = (ArrayList<Person>) request.getAttribute("elist");
				for (Person p : plist) {
		%>
		<tr>
			<td><%=p.getId()%></td>
			<td><%=p.getName()%></td>
			<td><%=p.getPassword()%></td>
			<td><%=p.getStatus()%></td>
			<%-- <td><a href="DeletePersonServlet?pid=<%=p.getId()%>">删除</a>  修改</td> --%>
			<td><input type="button" value="删除"
				onclick="del(<%=p.getId()%>)">
			<%--  <a href="personUpdate.jsp?id=<%=p.getId()%>&name=<%=p.getName()%>&pass=<%=p.getPassword()%>">修改</a> --%>
				<a href="UpdatePersonForwardServlet?id=<%=p.getId()%>">修改</a></td>
		</tr>
		<%
			}
			}
		%>
	</table>
	<a href="LoginOffServlet">注销</a>
</body>
</html>