<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/css_myInfo.css?after">
</head>

<script type="text/javascript">
	function del() {
		alert("예약이 삭제되었습니다");
	}
</script>

<body>
	<div id="logo">
		<img id="logoImg" src="image/logo3.JPG" alt="logo">
	</div>
	<table>
		<tr>
			<td><h2>내 정보</h2></td>
		</tr>
		<tr class="d">
			<td><b>이름:</b></td>
			<td>
				<%
					String userIDName = (String) session.getAttribute("userIDName");
				%> <%=userIDName%> <% 
					if (userIDName == null){
						pageContext.forward("main_notLogin.jsp");
					}
				%>
			</td>
		</tr>
		<tr>
			<td></td>
			<td></td>
		</tr>
		<tr class="d">
			<td style="border-bottom: 1px solid black;"><b>예약정보</b></td>
			<td></td>
		</tr>
		<tr>
			<td></td>
			<td></td>
		</tr>
		<c:forEach var="u" items="${li}">
			<tr>
				<td>${u.attractionName}</td>
				<td>${u.people}명</td>
				<td>${u.month}월</td>
				<td>${u.day}일</td>
				<td><a
					href="attractionServlet?type=del&attractionName=${u.attractionName}&people=${u.people}&month=${u.month}&day=${u.day}"
					onclick="del()">취소</a>
			</tr>
		</c:forEach>

	</table>
</body>
</html>