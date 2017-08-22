<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>student add</title>
</head>
<body>
	<hr>
	add student
	<hr>
	<form action="student" method="post">
		<input type="hidden" name="option" value="add"/><br>
		name:<input type="text" name="name"/><br>
		grade:<input type="text" name="grade"/><br>
		gander:<input type="radio" name="gander" value="1"/>男
			   <input type="radio" name="gander" value="0"/>女
		<br>
		<input type="submit" value="新增">
	</form>
</body>
</html>