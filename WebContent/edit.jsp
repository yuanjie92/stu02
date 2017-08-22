<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>student edit</title>
</head>
<body>
	<hr>
	edit student
	<hr>
		<a href="student">返回学生列表</a>
	<hr>
	
	<c:set var="gander" value="true" />
	<c:if test="${stu.gander == 0 }">
		<c:set var="gander" value="false" />
	</c:if>
	
	<form action="student" method="post">
		<input type="hidden" name="option" value="update"/><br>
		<input type="hidden" name="id" value="${stu.id }"/>
		name:<input type="text" name="name" value="${stu.name }"/><br>
		grade:<input type="text" name="grade" value="${stu.grade }"/><br>
		gander:<input type="radio" name="gander" ${gander?'checked':'' }  value="1"/>男
			   <input type="radio" name="gander" ${!gander?'checked':'' } value="0"/>女
		<br>
		<input type="submit" value="更新">
	</form>
</body>
</html>