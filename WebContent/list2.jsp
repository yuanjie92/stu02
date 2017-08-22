<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>student list2222322</title>
</head>
<body>
	<hr>
	<a href="add.jsp">新增学生</a>
	<hr>
	<table border="1">
		<thead>
			<tr>
				<th>序号</th>
				<th>姓名</th>
				<th>性别</th>
				<th>班级</th>
				<th>生日</th>
				<th colspan="2">操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${searchResults.results }" var="stu" varStatus="status">
				<tr>
					<td>${status.index+1 }</td>
					<td>${stu.name }</td>
					<td>
						<c:if test="${stu.gander==1 }">
							男
						</c:if>
						<c:if test="${stu.gander==0 }">
							女
						</c:if>
					</td>
					<td>${stu.grade }</td>
					<td>${stu.birthday }</td>
					<td><a href="student?option=del&id=${stu.id }">删除</a></td>
					<td><a href="student?option=showStu&id=${stu.id }">修改</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<c:set var="page" value="${searchResults.page }"/>
	
	<c:if test="${page.currentPage > 1}">
		<a href="student?currentPage=${page.currentPage-1 }">上一页</a>
	</c:if>

	${page.currentPage}

	<c:if test="${page.currentPage+1 <= page.totalPage }">
		<a href="student?currentPage=${page.currentPage+1 }">下一页</a>
	</c:if>
	<br>
,总共${page.totalPage }页
	
</body>
</html>