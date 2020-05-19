<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/css_manager_myInfo.css?after">
</head>

<script>
	function del() {
		alert("유저 삭제가 안료되었습니다.")
	}
</script>

<body>
	<div id="logo">
		<img id="logoImg" src="image/logo3.JPG" alt="logo">

	</div>
	<table>
		<tr>
			<td><h2>유저 관리</h2></td>
		</tr>
		<tr class="d">
			<td><b>이름:</b></td>
			<td>
				<%
				String userIDName = (String)session.getAttribute("userIDName");
			%> <%=userIDName %> (관리자)
			</td>
		</tr>
		<tr></tr>
		<tr class="d" style="border-bottom: 1px solid black;">
			<td><b>유저 번호</b></td>
			<td><b>유저 아이디</b></td>
			<td></td>
		</tr>
		<tr></tr>
		<c:forEach var="ul" items="${uli}">
			<tr>
				<td>${ul.userID}</td>
				<td>${ul.userIDName}</td>
				<td><a href="userServlet?type=del&userID=${ul.userID}" onclick="del()">삭제</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>